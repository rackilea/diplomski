public class Answer28535326 {

  private static void addRows(PreparedStatement ps, String line) throws SQLException {
    String[] records = line.split("~");
    for (String record : records) {
      String[] values = record.replaceAll("^\\*+", "").split("\\*+");
      for (int i = 0; i < values.length; i++) {
        ps.setString(i + 1, values[i]);
      }
      ps.addBatch();
    }
  }

  public static void main(String[] args) throws Exception {
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// Data Source Driver
    try ( Connection con = DriverManager.getConnection("jdbc:odbc:testing") ) {
      try ( PreparedStatement ps = con.prepareStatement("insert into testing (d1, d2, d3, d4, d5, d6) values(?, ?, ?, ?, ?, ?)") ) {
        try (BufferedReader in = new BufferedReader(new FileReader("2.txt"))) {
          String read = null;
          while ((read = in.readLine()) != null) {
            read = in.readLine();
            addRows(ps, read);
          }
          ps.executeBatch();
        }
      }
    }
  }
}