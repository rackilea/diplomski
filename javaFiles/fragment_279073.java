public class UpdateDB {

    public static void main(String[] args) {

        Connection c = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:/Users/Andrei/test.db");

            String sql = "SELECT * FROM sqlite_master WHERE type='table'";

            Statement stmt  = c.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);

            List<String> tableNames = new ArrayList<>();

            // loop through the result set
            while (rs.next()) {
                tableNames.add(rs.getString(3));
            }

            System.out.println("BEFORE UPDATE");
            System.out.println("---------------------------");

            for (String table: tableNames) {

                String sqlUpdate = "SELECT * FROM " + table + " ";
                ResultSet rs2 = stmt.executeQuery(sqlUpdate);

                while(rs2.next()) {
                    System.out.println(rs2.getInt("ID") + " " + rs2.getString("AGE"));
                }
            }

            // This is the statement which deletes the rows
            for (String table: tableNames) {
                String sqlUpdate = "DELETE FROM " + table + " WHERE AGE < 20";
                stmt.executeUpdate(sqlUpdate);
            }

            System.out.println();
            System.out.println("AFTER UPDATE");
            System.out.println("---------------------------");

            for (String table: tableNames) {

                String sqlUpdate = "SELECT * FROM " + table + " ";
                ResultSet rs2 = stmt.executeQuery(sqlUpdate);

                while(rs2.next()) {
                    System.out.println(rs2.getInt("ID") + " " + rs2.getString("AGE"));
                }
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}