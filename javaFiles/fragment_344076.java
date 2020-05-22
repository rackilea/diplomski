StringBuilder sql = new StringBuilder("INSERT INTO ").append(tableName).append(" (");
StringBuilder placeholders = new StringBuilder();

for (Iterator<String> iter = dataMap.keySet().iterator(); iter.hasNext();) {
    sql.append(iter.next());
    placeholders.append("?");

    if (iter.hasNext()) {
        sql.append(",");
        placeholders.append(",");
    }
}

sql.append(") VALUES (").append(placeholders).append(")");
preparedStatement = connection.prepareStatement(sql.toString());
int i = 0;

for (String value : dataMap.values()) {
    preparedStatement.setObject(i++, value);
}

int affectedRows = prepatedStatement.executeUpdate();
// ...