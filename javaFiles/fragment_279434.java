import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.{SparkConf, SparkContext}
import scala.collection.mutable.WrappedArray


object Demo {

  case class MyStruct(coordinates:Array[Array[Array[Double]]])
  case class MyRow(struct:MyStruct)

  def main(args: Array[String]): Unit = {

    val sc = new SparkContext(new SparkConf().setAppName("Demo").setMaster("local[*]"))
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    val data = MyRow(MyStruct(Array(Array(Array(1.0)))))
    val df= sc.parallelize(Seq(data)).toDF()

    // get first entry (row)
    val row = df.collect()(0)

    val arr = row.getAs[Row](0).getAs[WrappedArray[WrappedArray[WrappedArray[Double]]]](0)

    //access an element
    val res = arr(0)(0)(0)

    println(res) // 1.0

  }
}