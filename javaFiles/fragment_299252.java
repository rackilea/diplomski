ResultSet rs = connection.getMetaData().getProcedureColumns(null, "dbo", "MenuPlanner", null);
while (rs.next()) {
    if (rs.getShort("COLUMN_TYPE") == DatabaseMetaData.procedureColumnIn) {
        String inParamName = rs.getString("COLUMN_NAME");
        System.out.println(inParamName);
    }
}