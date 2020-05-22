import org.apache.spark.sql.expressions.UserDefinedFunction;
import org.apache.spark.sql.types.DataTypes;
import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.udf;

    UserDefinedFunction mode = udf((Integer a, Integer b, Integer c) -> a+b+c, DataTypes.IntegerType);
    df.select(col("id"), mode.apply(col("a"), col("b"), col("c")).as("(a+b+c)")).show(false);