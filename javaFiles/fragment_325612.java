class DataSets {
  final private DataSetsSerializer serializer;

  public DataSets(DataSetsSerializer serializer, String data) {
    this.serializer = serializer;
    serializer.unserialize(this, data);
  }

  @Override
  public String getSerializedVersion() {
    return serializer.serialize(this);
  }
}