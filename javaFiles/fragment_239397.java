public class SparkSample{
public static void main(String[] args) {
    SparkConf conf = new SparkConf().setAppName("SparkSample").setMaster("local[*]");
    JavaSparkContext jsc = new JavaSparkContext(conf);
    SQLContext sqc = new SQLContext(jsc);
    // sample data
    List<String> data = new ArrayList<String>();
    data.add("dev, engg, 10000");
    data.add("karthik, engg, 20000");
    // DataFrame
    DataFrame df = sqc.createDataset(data, Encoders.STRING()).toDF();
    df.printSchema();
    df.show();
    // Convert
    DataFrame df1 = df.selectExpr("split(value, ',')[0] as name", "split(value, ',')[1] as degree","split(value, ',')[2] as salary");
    df1.printSchema();
    df1.show(); 
   }
}