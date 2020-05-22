import static org.apache.spark.sql.functions.*;
import org.apache.spark.sql.expressions.UserDefinedFunction;

UserDefinedFunction udfUppercase = udf(
  (String s) -> s.toUpperCase(), DataTypes.StringType
);

df.select(udfUppercase.apply(col("name")));