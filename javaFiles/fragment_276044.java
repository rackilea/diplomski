scala> import sqlContext.implicits._
import sqlContext.implicits._

scala> val df  = sc.textFile("/user/test/files/spark_test.txt").map(_.split(',')).map(x => (x(0),x(1),x(2),x(3),x(4),x(5))).toDF("c1","c2","c3","c4","c5","c6")
df: org.apache.spark.sql.DataFrame = [c1: string, c2: string, c3: string, c4: string, c5: string, c6: string]

scala> df.explode("c6","c7")((x:String) => x.split('|')).drop("c6").show()
{"level": "INFO ", "timestamp": "2017-01-30 01:13:09,138", "classname": "com.hadoop.compression.lzo.GPLNativeCodeLoader", "body": "Loaded native gpl library"}
{"level": "INFO ", "timestamp": "2017-01-30 01:13:09,141", "classname": "com.hadoop.compression.lzo.LzoCodec", "body": "Successfully loaded & initialized native-lzo library [hadoop-lzo rev 2cedc48fab9e2e10a84b909b4c198053ff379ac7]"}
+---+---+---+----+---+---+
| c1| c2| c3|  c4| c5| c7|
+---+---+---+----+---+---+
|EEL|  A|CAT|LOC1|EEX| 13|
|EEL|  A|CAT|LOC1|EEX| 42|
|EEL|  A|CAT|LOC1|EEX| 45|
|EEL|  A|CAT|LOC1|EEX| 67|
|EEL|  A|CAT|LOC2|EEX| 24|
|EEL|  A|CAT|LOC2|EEX| 32|
+---+---+---+----+---+---+