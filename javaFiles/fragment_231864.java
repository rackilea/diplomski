import org.apache.spark.SparkConf;
import org.apache.spark.deploy.yarn.Client;
import org.apache.spark.deploy.yarn.ClientArguments;
import org.apache.hadoop.conf.Configuration;
import org.apache.log4j.Logger;

public class SubmitSparkAppToYARNFromJavaCode {
    public static void main(String[] args) throws Exception {
        run(); 
    }
    static void run() throws Exception {
        String sparkExamplesJar = "/opt/spark/examples/jars/spark-examples_2.11-2.0.0.jar";
        final String[] args = new String[]{
            "--jar",
            sparkExamplesJar,
            "--class",
            "org.apache.spark.examples.JavaWordCount",
            "--arg",
            "hdfs://hadoop-master:9000/input/file.txt"
        };
        Configuration config = ConfigurationManager.createConfiguration();     
        System.setProperty("SPARK_YARN_MODE", "true");
        SparkConf sparkConf = new SparkConf();
        sparkConf.setSparkHome(SPARK_HOME);
        sparkConf.setMaster("yarn");
        sparkConf.setAppName("spark-yarn");
        sparkConf.set("master", "yarn");
        sparkConf.set("spark.submit.deployMode", "cluster");
        ClientArguments clientArguments = new ClientArguments(args); 
        Client client = new Client(clientArguments, config, sparkConf);
        client.run();
    }
}