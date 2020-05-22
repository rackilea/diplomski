import org.apache.spark.sql.functions.{posexplode, col, array}

val cols = Seq("prod_id", "prod_name").map{col(_)}
val customArray = array(cols:_*)

df.select(customArray).show