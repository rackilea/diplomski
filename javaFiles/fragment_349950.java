// Bit lazy with columns names, but anyway.

import org.apache.spark.sql.functions.input_file_name  
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._ 
import spark.implicits._

val inputPath: String = "/FileStore/tables/g*.txt"  
val rdd = spark.read.text(inputPath)
  .select(input_file_name, $"value")   
  .as[(String, String)] 
  .rdd

val rdd2 = rdd.zipWithIndex
val rdd3 = rdd2.map(x => (x._1._1, x._2, x._1._2.split(",").toList.map(_.toInt)))  
val rdd4 = rdd3.map { case (pfx, pfx2, list) => (pfx,pfx2,list.zipWithIndex) }
val df = rdd4.toDF()
df.show(false)
df.printSchema()

val df2 = df.withColumn("rankF", row_number().over(Window.partitionBy($"_1").orderBy($"_2".asc)))
df2.show(false)
df2.printSchema()

val df3 = df2.withColumn("elements", explode($"_3"))
df3.show(false)
df3.printSchema()

val df4 = df3.select($"_1", $"rankF", $"elements".getField("_1"), $"elements".getField("_2")).toDF("fn", "line_num", "val", "col_pos")
df4.show(false)
df4.printSchema()

df4.createOrReplaceTempView("df4temp")

val df51 = spark.sql("""SELECT hdr.fn, hdr.line_num, hdr.val AS pfx, hdr.col_pos
                          FROM df4temp hdr
                         WHERE hdr.line_num <> 1
                           AND hdr.col_pos = 0
                     """) 
df51.show(100,false)

val df52 = spark.sql("""SELECT t1.fn, t1.val AS val1, t1.col_pos, t2.line_num, t2.val AS val2
                          FROM df4temp t1, df4temp t2
                         WHERE t1.col_pos  <> 0
                           AND t1.col_pos  = t2.col_pos 
                           AND t1.line_num <> t2.line_num
                           AND t1.line_num = 1
                           AND t1.fn       = t2.fn
                     """)
df52.show(100,false)

df51.createOrReplaceTempView("df51temp")
df52.createOrReplaceTempView("df52temp")

val df53 = spark.sql("""SELECT DISTINCT t1.pfx, t2.val1, t2.val2
                          FROM df51temp t1, df52temp t2
                         WHERE t1.fn = t2.fn 
                           AND t1.line_num = t2.line_num
                     """)
df53.show(false)