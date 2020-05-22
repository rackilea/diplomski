public class BUDataColumnsFinder {

public static String[] readSql(String schema) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(schema)));
    String mysql = "";
    String line;
    while ((line = br.readLine()) != null) {
        mysql = mysql + line;
    }
    br.close();
    mysql = mysql.replaceAll("`", "");
    return mysql.split(";");
}

public static List<String> getColumnNames(String tableName, String schemaFile) throws JSQLParserException, IOException {

    CCJSqlParserManager pm = new CCJSqlParserManager();
    List<String> columnNames = new ArrayList<String>();

    String[] sqlStatements = readSql(schemaFile);

    for (String sqlStatement : sqlStatements) {

        Statement statement = pm.parse(new StringReader(sqlStatement));

        if (statement instanceof CreateTable) {

            CreateTable create = (CreateTable) statement;
            String name = create.getTable().getName();

            if (name.equalsIgnoreCase(tableName)) {
                List<ColumnDefinition> columns = create.getColumnDefinitions();
                for (ColumnDefinition def : columns) {
                    columnNames.add(def.getColumnName());
                }
                break;
            }
        }
    }

    return columnNames;
}


public static void main(String[] args) throws Exception {

    String schemaFile = "/home/john/config/bu-schema.sql";

    String tableName = "records";

    List<String> columnNames = BUDataColumnsFinder.getColumnNames(tableName, schemaFile);

    for (String name : columnNames) {
        System.out.println("name: " + name);
    }

}

}