import org.yaml.snakeyaml.Yaml;
import scala.collection.JavaConversions;

Yaml yaml = new Yaml();  
InputStream is = MySparkApplication.class.getClassLoader().getResourceAsStream("application.yaml");
Map<String, Object> yamlParsers = (Map<String, Object>) yaml.load(is);
LinkedHashMap<String,Object> spark = (LinkedHashMap<String,Object>) yamlParsers.get("spark"); 
LinkedHashMap<String,String> config = (LinkedHashMap<String,String>) spark.get("conf");
SparkConf conf = new SparkConf()
             .setAppName((String) spark.get("appname"))
             .setMaster((String) spark.get("master"))
             .setAll(JavaConversions.mapAsScalaMap(config));