public class Utils {

  public static <T> JavaPairRDD<String, T> loadAvroFile(JavaSparkContext sc, String avroPath) {
    JavaPairRDD<AvroKey, NullWritable> records = sc.newAPIHadoopFile(avroPath, AvroKeyInputFormat.class, AvroKey.class, NullWritable.class, sc.hadoopConfiguration());
    return records.keys()
        .map(x -> (GenericRecord) x.datum())
        .mapToPair(pair -> new Tuple2<>((String) pair.get("key"), (T)pair.get("value")));
  }
}