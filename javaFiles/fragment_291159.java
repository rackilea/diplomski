public class ServerAwareNamingStrategy extends ImprovedNamingStrategy {

    @Override
    public String classToTableName(String className) {
        String tableName = super.classToTableName(className);
        return resolveServer(tableName);
    }

    private String resolveServer(String tableName) {
        StringBuilder tableNameBuilder = new StringBuilder();

        tableNameBuilder.append(tableName);
        tableNameBuilder.append("_");
        tableNameBuilder.append(System.getProperty("SERVER_NAME"));

        return tableNameBuilder.toString();
    }
}