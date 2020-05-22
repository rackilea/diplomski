public boolean insert(Connection conn, String table, List<String> columns, List<String> values) throws SQLException {
    StringBuilder sb = new StringBuilder();

    sb.append("INSERT INTO ");
    sb.append(table);
    sb.append(" (");

    // add columns
    Iterator<String> it = columns.iterator();
    sb.append(it.next());
    while(it.hasNext()) {
        sb.append(',');
        sb.append(it.next());
    }

    sb.append(") VALUES (");

    // add values
    it = values.iterator();
    sb.append(it.next());
    while(it.hasNext()) {
        sb.append(',');
        sb.append(it.next());
    }

    sb.append(");");

    // insert
    try (Statement stmt = conn.createStatement()) {
        return stmt.execute(sb.toString());
    }
}