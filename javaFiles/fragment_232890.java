public class TableAliasMapperJdbc {
    public Map<String, List<String>> mapTableAliases(String url, String user, String password, String sql) throws SQLException {
        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            // we use conn.getMetaData().getConnection() instead of conn here only to fit within the parameters of the question
            PreparedStatement stmt = conn.getMetaData().getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
        ) {
            // this may not do what you want if you have synonyms of synonyms
            Map<String, List<String>> tableAliases = new HashMap<>();
            while (rs.next()) {
                String table = rs.getString(1);
                String alias = rs.getString(2);
                List<String> aliases = tableAliases.get(table);
                if (aliases == null) {
                    tableAliases.put(table, aliases = new ArrayList<>(2));
                }
                aliases.add(alias);
            }
            return tableAliases;
        }
    }

    public void print(String dbName, Map<String, List<String>> tableAliases) {
        System.out.format("\nThe following are the table aliases for %s:\n", dbName);
        for (Map.Entry<String, List<String>> entry : tableAliases.entrySet()) {
            System.out.format("The alias(es) for %s are: %s.\n", entry.getKey(), String.join(", ", entry.getValue()));
        }
    }

    public static void main(String[] args) throws SQLException {
        TableAliasMapperJdbc mapper = new TableAliasMapperJdbc();
        mapper.print("Oracle",
            mapper.mapTableAliases(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "scott",
                "tiger",
                "SELECT table_name, synonym_name FROM user_synonyms")); // or maybe all_synonyms

        mapper.print("DB2",
            mapper.mapTableAliases(
                "jdbc:db2://localhost:50000/SAMPLE",
                "db2admin",
                "db2admin",
                "SELECT base_tabname, tabname FROM syscat.tables WHERE type = 'A' AND owner = 'DB2ADMIN'"));

        mapper.print("SQL Server",
            mapper.mapTableAliases(
                "jdbc:sqlserver://localhost:1433",
                "sa",
                "Password123",
                "SELECT PARSENAME(base_object_name,1), name FROM sys.synonyms"));
    }
}