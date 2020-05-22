public class HSqlDbTest {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:hsqldb:mem:test";
        Class.forName("org.hsqldb.jdbcDriver");
        try (Connection connection = DriverManager.getConnection(url, "sa", "")) {
            String createTableSql = "" +
                    "create table test (" +
                    "  a integer not null,            " +
                    "  b integer not null,            " +
                    "  constraint a_uniq unique (a),  " +
                    "  constraint b_uniq unique (b)   " +
                    ")                                ";
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(createTableSql);
            }

            try (PreparedStatement statement = connection.prepareStatement("insert into test (a, b) values (?, ?)")) {
                statement.setInt(1, 1);
                statement.setInt(2, 1);
                statement.executeUpdate();

                statement.setInt(1, 2);
                statement.setInt(2, 1);
                statement.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e) {
                Pattern pattern = Pattern.compile("integrity constraint violation: unique constraint or index violation; (\\w+) table: (\\w+)");
                Matcher matcher = pattern.matcher(e.getMessage());
                if (matcher.matches()) {
                    String constraintName = matcher.group(1);
                    String tableName = matcher.group(2);
                    System.out.printf("Violated constrant \"%s\" in the table \"%s\"\n", constraintName, tableName);
                }
            }
        }
    }
}