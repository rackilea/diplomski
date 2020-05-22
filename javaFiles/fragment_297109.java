import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
....


  public static void processYourMessages(final JavaRDD<YourMessage> rdd, final HiveContext sqlContext, 
                    , MyMessageUtil messageutil) throws Exception {
        final JavaRDD<Row> yourrdd = rdd.filter(msg -> messageutil.filterType(.....) // create a java rdd
        final JavaPairRDD<ImmutableBytesWritable, Put> yourrddPuts = yourrdd.mapToPair(row -> messageutil.getPuts(row));
        yourrddPuts.saveAsNewAPIHadoopDataset(conf);       
    }