class YAMLDataSetsSerializer implements DataSetsSerializer
{
  public DataSets unserialize(String string) {
    DataSets sets = new DataSets();
    ...
  }

  public String serialize(DataSets sets) {
    ...
  }
}