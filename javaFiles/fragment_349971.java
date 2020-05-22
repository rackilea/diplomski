connection = new Dispatch("ADODB.Connection");
Dispatch.call(connection, "Open", "Provider=Search.CollatorDSO;Extended Properties='Application=Windows';");

String sql = "SELECT System.ItemName, System.DateModified " +
    "FROM SystemIndex " +
    "WHERE Directory='file:C:/my/folder/path' AND Contains('a')"

recordSet = new Dispatch("ADODB.Recordset");
Dispatch.put(recordSet, "MaxRecords", new Variant(10));

Dispatch.call(recordSet, "Open", sql, connection);

while (!Dispatch.get(recordSet, "EOF").getBoolean()) {
    ...
}