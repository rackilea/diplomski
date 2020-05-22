public class GeomesaClient {
  private AccumuloDataStore ds = null;
  private AccumuloAppendFeatureWriter fw = null;
  private SimpleFeatureSource sfs = null;
  private String tableName = "";
  private FeatureStore fst = null;
  private SimpleFeatureType sft;

  public GeomesaClient(Map<String, String> dsConf) throws Exception {
    this.ds = (AccumuloDataStore) DataStoreFinder.getDataStore(dsConf);
    this.tableName = dsConf.get("tableName");

    sft = createFeatureType();
    if(!Arrays.asList(this.ds.getTypeNames()).contains(sft.getTypeName())){
      ds.createSchema(sft);
    }
    this.fst = (FeatureStore)sfs;
    this.fw = (AccumuloAppendFeatureWriter) (this.ds.getFeatureWriterAppend(sft.getTypeName(),
        Transaction.AUTO_COMMIT));
    this.sfs = ds.getFeatureSource(sft.getTypeName());
  }
  /*
        Flush with AccumuloAppendFeatureWriter
  */
  public void flush(boolean force) {
    fw.flush();
  }
}