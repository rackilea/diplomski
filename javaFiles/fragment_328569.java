Map<Long, List<Data>> groups = new HashMap<Long, List<Data>>();
while (resultSet.next()) {
    Long groupId = resultSet.getLong("groupId");
    String col1 = resultSet.getString("col1");
    String col2 = resultSet.getString("col2");
    // ...
    List<Data> group = groups.get(groupId);
    if (group == null) {
        group = new ArrayList<Data>();
        groups.put(groupId, group);
    }
    group.add(new Data(groupId, col1, col2 /* ... */));
}