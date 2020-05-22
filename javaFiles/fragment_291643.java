StringBuilder query = new StringBuilder();
query.append("INSERT INTO ")
     .append(queryBuilder.getTableName())
     .append(" (");
for (int i = 0; i < queryBuilder.getColumns().size(); i++) {
    if (i != 0)
        query.append(", ");
    query.append(queryBuilder.getColumns().get(i));
}
query.append(") VALUES (");
for (int i = 0; i < queryBuilder.getValues().size(); i++) {
    if (i != 0)
        query.append(", ");
    query.append("?");
}
query.append(")");