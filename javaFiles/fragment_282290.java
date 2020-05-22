public class ResultSetCsvInputStream extends InputStream {

 private ResultSet rs;
 private int columns;

 private int ch;
 private byte[] line;

 /**
  * Construct a new SchemaInputStream
  * @param rs
  * @throws SQLException 
  */
 public ResultSetCsvInputStream(ResultSet rs) throws SQLException {

  this.rs = rs;

  // write column names
  ResultSetMetaData meta = rs.getMetaData();
  columns = meta.getColumnCount();
  String[] colNames = new String[columns];
  for(int i = 0; i < colNames.length; i++) {
   colNames[i] = meta.getColumnName(i+1);
  }
  writeLine(colNames);

 }

 private void writeLine(String[] ln) {
  StringWriter strWriter = new StringWriter();
  CSVWriter csv = new CSVWriter(strWriter);
  csv.writeNext(ln);
  line = strWriter.toString().getBytes(Charset.forName("UTF8"));
  ch = 0;
 }

 @Override
 public int read() throws IOException {

  if(rs == null)
   return -1;

  // read the next line
  if(line == null || ch >= line.length) {

   // query next line
   try {
    if(rs.next()) {
     String[] record = new String[columns];
     for(int i = 0; i < record.length; i++) {
      record[i] = rs.getString(i+1);
     }
     writeLine(record);
    }
    else {
     rs = null;
     return -1;
    }
   } catch (SQLException e) {
    throw new IOException(e);
   }

  }

  // read next character
  return line[ch++] & 0xFF;

 }

}