Map<Integer,List<String>> map = new HashMap<>();
while (resultSet.next()) {
    String key = resultSet.getInt(1);
    String value = resultSet.getString(2);
    List<String> values = map.get(key);
    if (values == null) {
        values = new ArrayList<String>();
        map.put(key,values);
    }
    values.add(value);
}