static void method2() {

    String sql = "select * from Customers";

    try (ClosableResultSet rs = Factory.createResultSet(
            sql,
            (e, action) -> System.out.print(action + ": " + e.getMessage())
    )) {
        while (rs.next()) {
            System.out.print("Name: " + rs.getString("name") + "\n");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

}