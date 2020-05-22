Map<String, List<String>> mapGroups = new HashMap<>(25);
while (resultSet.next()) {
    String group = resultSet.getString("colNode");
    List<String> members = mapGroups.get(group);
    if (members == null) {
        members = new ArrayList<>(25);
        mapGroups.put(group, members);
    }
    members.add(resultSet.getString("colLeaf"));
}