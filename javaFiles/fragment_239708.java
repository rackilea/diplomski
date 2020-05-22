public class DAO {

    private Connection conn ;


    public DAO() {
        // initialize connection...
    }

    public DataResult getAllData() throws SQLException {

        List<List<Object>> data = new ArrayList<>();
        List<String> columnNames = new ArrayList<>();

        try (
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select * from some_table")) {


            int columnCount = rs.getMetaData().getColumnCount();

            for (int i = 1 ; i <= columnCount ; i++) {
                columnNames.add(rs.getMetaData().getColumnName(i));
            }

            while (rs.next()) {
                List<Object> row = new ArrayList<>();
                for (int i = 1 ; i <= columnCount ; i++) {
                    row.add(rs.getObject(i));
                }
                data.add(row);
            }
        }

        return new DataResult(columnNames, data);
    }
}