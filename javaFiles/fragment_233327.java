public static void main(final String args) {
  final DatabaseConnection conn = new DatabaseConnection(getConnectionToDbWithRealData());
  final QueryDataSet dataset = new QueryDataSet(conn);
  dataset.addTable("foo", "select * from foo where bar = 'xyz'");
  new CsvDataSetWriter(getOutputFile()).write(dataset);
}