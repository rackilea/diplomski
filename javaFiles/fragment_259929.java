public List<Map<String, String>> resultSetToArrayList(ResultSet rs) {
    List<Map<String, String>> list = new ArrayList<>();
    try {
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        while (rs.next()) {
            Map<String, String> row = new HashMap<>();
            for (int i = 1; i <= columns; ++i) {
                row.put(md.getColumnName(i), rs.getString(i));
            }
            list.add(row);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}