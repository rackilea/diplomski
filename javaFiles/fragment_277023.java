Map<String, Object> params = new HashMap<>();
params.put("props", new HashMap<String, Object>() {
    add("name", name);
    add("contactEmail", contactEmail);
});

String query = "CREATE (t:TestEntity  {props})"
db.execute(query, params);