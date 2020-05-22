boolean isMssqlJdbc = connection.getClass().getName().equals(
        "com.microsoft.sqlserver.jdbc.SQLServerConnection");
ResultSet rs = connection.getMetaData().getProcedureColumns(null, "dbo", "MenuPlanner", null);
while (rs.next()) {
    if (rs.getShort("COLUMN_TYPE") == DatabaseMetaData.procedureColumnIn) {
        String inParamName = rs.getString("COLUMN_NAME");
        if (isMssqlJdbc && inParamName.startsWith("@")) {
            inParamName = inParamName.substring(1, inParamName.length());
        }
        System.out.println(inParamName);
    }
}