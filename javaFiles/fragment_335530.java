import org.apache.spark.mllib.rdd.RDDFunctions._

val first = rdd.first match {
  case NameValue(name, value) => NameValueWithLag(name, value, value)
}

sc.parallelize(Seq(first)).union(rdd
  .sliding(2)
  .map(a => NameValueWithLag(a(1).name, a(1).value, a(1).value - a(0).value)))