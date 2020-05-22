public class Main {

private class StreamResourceAccessor extends AbstractResourceAccessor {
    private String json;
    public StreamResourceAccessor(String jsonString) {
        super();
        this.json = jsonString;
    }

    @Override
    public Set<InputStream> getResourcesAsStream(String name) throws IOException {
        InputStream stream = new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8));

        Set<InputStream> returnSet = new HashSet<>();
        returnSet.add(stream);
        return returnSet;
    }

    @Override
    public Set<String> list(String arg0, String arg1, boolean arg2, boolean arg3, boolean arg4) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ClassLoader toClassLoader() {
        // TODO Auto-generated method stub
        return null;
    }

}

public static void main(String[] args) throws SQLException, LiquibaseException {
    String url = "jdbc:postgresql://localhost/postgres";
    Properties props = new Properties();
    props.setProperty("user","postgres");
    props.setProperty("password","");
    //props.setProperty("ssl","true");
    Connection connection = DriverManager.getConnection(url, props);

    Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
    String jsonText = "{\"databaseChangeLog\":[{\"preConditions\":[{\"runningAs\":{\"username\":\"postgres\"}}]},{\"changeSet\":{\"id\":\"1\",\"author\":\"nvoxland\",\"changes\":[{\"createTable\":{\"tableName\":\"person\",\"columns\":[{\"column\":{\"name\":\"id\",\"type\":\"int\",\"autoIncrement\":true,\"constraints\":{\"primaryKey\":true,\"nullable\":false},}},{\"column\":{\"name\":\"firstname\",\"type\":\"varchar(50)\"}},{\"column\":{\"name\":\"lastname\",\"type\":\"varchar(50)\",\"constraints\":{\"nullable\":false},}},{\"column\":{\"name\":\"state\",\"type\":\"char(2)\"}}]}}]}},{\"changeSet\":{\"id\":\"2\",\"author\":\"nvoxland\",\"changes\":[{\"addColumn\":{\"tableName\":\"person\",\"columns\":[{\"column\":{\"name\":\"username\",\"type\":\"varchar(8)\"}}]}}]}},{\"changeSet\":{\"id\":\"3\",\"author\":\"nvoxland\",\"changes\":[{\"addLookupTable\":{\"tableName\":\"person\",\"existingTableName\":\"person\",\"existingColumnName\":\"state\",\"newTableName\":\"state\",\"newColumnName\":\"id\",\"newColumnDataType\":\"char(2)\",}}]}}]}";

    Main main = new Main();
    ResourceAccessor resourceAccessor = main.new StreamResourceAccessor(jsonText);

    Liquibase liquibase = new Liquibase("hello.json", resourceAccessor, database);
    try {
        Contexts context = new Contexts();
        liquibase.update(context);
    } catch (Exception e) {
        System.out.println(e);
    }
}

}