List<String> names = new ArrayList<String>();
names.add("Alice");
names.add("Bob");
String sql = "SELECT * FROM people WHERE name IN UNNEST(@names)";
Statement statement = Statement
                .newBuilder(sql)
                .bind("names").toStringArray(names)
                .build();