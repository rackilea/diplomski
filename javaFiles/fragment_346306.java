org.apache.spark.mllib.linalg.Vector; case class 

case class LabeledPointWithMeta(userNo: String, label: Double, features: Vector)

val rdd: RDD[LabeledPointWithMeta] = ???
val df = rdd.toDF