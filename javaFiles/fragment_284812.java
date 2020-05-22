// Input data
val df = {
  import org.apache.spark.sql._
  import org.apache.spark.sql.types._
  import scala.collection.JavaConverters._

  val simpleSchema = StructType(
    StructField("dataOne", StringType) ::
    StructField("OtherData", StringType) ::
    StructField("dataTwo", StringType) ::
    StructField("dataThree", IntegerType) :: Nil)

  val data = List(
    Row("Best", "tree", "5", 533),
    Row("OK", "bush", "e", 3535),
    Row("MEH", "cow", "-", 3353),
    Row("MEH", "oak", "none", 12)
  )

  spark.createDataFrame(data.asJava, simpleSchema)
}

df.show