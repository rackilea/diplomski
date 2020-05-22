static class IntValue {
  private int data;

  IntValue() {}
  IntValue(int data) { this.setData(data); }

  int getData() { return this.data; }
  void setData(int data) { this.data = data; }
}
static class Snapshot<T> {
  private T value;

  Snapshot() {}

  T getValue() { return value; }
  void setValue(T value) { this.value = value; }
}
private static Schema buildSnapshotSchema(Schema valueSchema) {
  return SchemaBuilder.record("Snapshot")
      .namespace("blah")
      .fields()
      .name("value").type(valueSchema).noDefault()
      .endRecord();
}

@Test
public void testStackOverflowPost() throws Exception {
  AvroCoder.of(Snapshot.class, buildSnapshotSchema(AvroCoder.of(IntValue.class).getSchema()));
}