import org.apache.spark.sql.expressions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions.udf
import org.apache.spark.sql.{Row, Column}

object DummyUDAF extends UserDefinedAggregateFunction {
  def inputSchema = new StructType().add("x", StringType)
  def bufferSchema = new StructType()
    .add("buff", ArrayType(LongType))
    .add("buff2", ArrayType(DoubleType))
  def dataType = new StructType()
    .add("xs", ArrayType(LongType))
    .add("ys", ArrayType(DoubleType))
  def deterministic = true 
  def initialize(buffer: MutableAggregationBuffer) = {}
  def update(buffer: MutableAggregationBuffer, input: Row) = {}
  def merge(buffer1: MutableAggregationBuffer, buffer2: Row) = {}
  def evaluate(buffer: Row) = (Array(1L, 2L, 3L), Array(1.0, 2.0, 3.0))
}

val df =  sc.parallelize(Seq(("a", 1), ("b", 2))).toDF("k", "v")
df.select(DummyUDAF($"k")).show(1, false)

// +---------------------------------------------------+
// |(DummyUDAF$(k),mode=Complete,isDistinct=false)     |
// +---------------------------------------------------+
// |[WrappedArray(1, 2, 3),WrappedArray(1.0, 2.0, 3.0)]|
// +---------------------------------------------------+