import org.apache.spark.mllib.linalg.VectorUDT
import org.apache.spark.sql.types.{LongType, StructField, StructType}

val schema = StructType(Seq(
  StructField("_1", LongType, true),
  StructField("_2", new VectorUDT, true)))

spark.read.schema(schema).json(path).printSchema
root
 |-- _1: long (nullable = true)
 |-- _2: vector (nullable = true)

spark.read.schema(schema).json(path).show(1)
// +---+-------------------+
// | _1|                 _2|
// +---+-------------------+
// |  1|(5,[1,3],[2.0,3.0])|
// +---+-------------------+