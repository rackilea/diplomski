public void foo() {
    try (Connection conn = datasource.getConnection()) {
        //your code here
    } catch (SQLException e) {
        e.printStackTrace();
    }
}