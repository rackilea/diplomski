public static String buildCreateTable(String tableName, String ... columnsAndTypes) {
    StringBuilder sql = new StringBuilder();
    sql.append("CREATE TABLE ").append(tableName).append(" ( ")
       .append(columnsAndTypes[0]).append(' ').append(columnsAndTypes[1]).append(" PRIMARY KEY AUTOINCREMENT");
    for(int i = 2; i < columnsAndTypes.length; i+=2)
        sql.append(", ").append(columnsAndTypes[i]).append(' ').append(columnsAndTypes[i + 1]);
    sql.append(" )");
    return sql.toString();
}