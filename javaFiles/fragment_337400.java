for (String param : s1.ListViewCategory) {
    sb.append(",?");
}
String[] array = ListViewCategory.toArray(new String[s1.ListViewCategory.size()]);

params = sb.toString().substring(1);
String sql = "SELECT CATEGORY FROM " + tableName
           + " WHERE CATEGORY NOT IN (@) "
           + " ORDER BY RANDOM() LIMIT 1 ";
sql = sql.replace("@", params);

Cursor cursor = database.rawQuery(sql, array);