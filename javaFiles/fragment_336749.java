// Foo is some unknown object that encapsulates each row.
List<Foo> results = new ArrayList<Foo>();
Map<String, Object> rows = (Map<String, Object>) out.get("#result-set-1");
for (Map row : rows) {
    int id = row.get("id");
    int out1 = row.get("out1");
    double distance = row.get("distance");
    results.add(new Foo(id, out1, distance));
}
return results;