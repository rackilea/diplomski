import java.util.Arrays;
import java.util.List;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.spark.japi.CouchbaseDocumentRDD;
import com.couchbase.spark.japi.CouchbaseSparkContext;

public class CouchBaseDemo {
    public static void main(String[] args) {
        //JavaSparkContext
        SparkConf conf = new SparkConf().setAppName("CouchBaseDemo").setMaster("local").set("com.couchbase.bucket.travel-sample", "");
        JavaSparkContext jsc = new JavaSparkContext(conf);
        CouchbaseSparkContext csc = CouchbaseSparkContext.couchbaseContext(jsc);
        //Create and save JsonDocument
        JsonDocument docOne = JsonDocument.create("docOne", JsonObject.create().put("new", "doc-content"));
        JavaRDD<JsonDocument> jRDD = jsc.parallelize(Arrays.asList(docOne));
        CouchbaseDocumentRDD<JsonDocument> cbRDD = CouchbaseDocumentRDD.couchbaseDocumentRDD(jRDD);
        cbRDD.saveToCouchbase();
        //fetch JsonDocument
        List<JsonDocument> doc = csc.couchbaseGet(Arrays.asList("docOne")).collect();
        System.out.println(doc);
    }
}