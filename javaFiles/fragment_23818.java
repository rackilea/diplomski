import org.apache.spark.api.java.function.Function;
import org.apache.hadoop.hbase.util.Bytes;
import scala.Tuple2;

JavaRDD<String> javaRDD = javaPairRdd.map(new Function<Tuple2<ImmutableBytesWritable,Result>, String>() {
    @Override
    public String call(Tuple2<ImmutableBytesWritable, Result> tuple) throws Exception {
        Result result = tuple._2;
        String rowKey = Bytes.toString(result.getRow());//row key
        String fName = Bytes.toString(result.getValue(Bytes.toBytes("myColumnFamily"), Bytes.toBytes("firstName")));//firstName column 
        return fName;
    }       
});