// construct a map with string key (tag) and list of integers (ids) as the value
Map<String, List<Integer>> keywords = new HashMap<String, List<Integer>>();

while (rs.next()) {
    int id = rs.getInt("uid");
    String query = "select tags.tagname from tags left join tag_url_relation on tags.tid=tag_url_relation.tid where tag_url_relation.uid="+id;
    ResultSet rs1 = st1.executeQuery(query);

    while (rs1.next()){
        String tag = rs1.getString(1);

        // construct the List for this keyword
        if (!keywords.containsKey(tag)) {
            keywords.put(tag, new ArrayList<Integer>());
        } 
        keywords.get(tag).add(id);
    }
}