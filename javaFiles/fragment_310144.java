import static org.apache.spark.sql.functions.*;
import org.apache.spark.sql.expressions.UserDefinedFunction;

UserDefinedFunction mode = udf(
  (Seq<String> ss) -> ss.headOption(), DataTypes.StringType
);

df.select(mode.apply(col("vs"))).show();