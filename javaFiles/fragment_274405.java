import org.apache.spark.sql.types._
import org.apache.spark.sql.types.{IntegerType, StringType}

val schemaString = "Field1 Field2 FieldDate1 Field3"
val fields = schemaString.split(" ")
                         .map(fieldName => StructField(fieldName, StringType, nullable=true))