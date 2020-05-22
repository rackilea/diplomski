public class DataStoreFactory {

  public static DataStoreWriter<String> dataStoreWriter(Configuration hadoopConfiguration, String basePath) {
    // do something here
    TextFileWriter writer = new TextFileWriter(hadoopConfiguration, new Path(basePath), null);
    return writer;
  }
}