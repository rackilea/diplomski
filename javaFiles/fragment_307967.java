Map<String, List<String>> categoryMap = new HashMap<>();
while(rs.next()){
    List<String> namesForCategory = categoryMap.getOrDefault(rs.getString("category"), new ArrayList<>());
    namesForCategory.add(rs.getString("name"));
    categoryMap.put(rs.getString("category"), namesForCategory);
}