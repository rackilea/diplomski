private boolean checkRecordExist(String tableName, String[] keys, String [] values) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < keys.length; i++) {
        sb.append(keys[i])
            .append("=\"")
            .append(values[i])
            .append("\" ");
        if (i<keys.length-1) sb.append("AND ");
    }

    Cursor cursor = database.query(tableName, null, sb.toString(), null, null, null, null);
    boolean exists = (cursor.getCount() > 0);
    cursor.close();
    return exists;
}