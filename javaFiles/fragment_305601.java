} else {
    for (String name : columns) {
        queryBuilder.append(name);
        queryBuilder.append(", ");
    }
    queryBuilder.setLength(queryBuilder.length() - 2);
}
//queryBuilder.setLength(queryBuilder.length() - 2);
queryBuilder.append(" from ");
queryBuilder.append(tableName);