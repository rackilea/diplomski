List<Tuple> tuples = service.findEmployeeList(2);
for (Tuple t : tuples) {
    StringBuilder builder = new StringBuilder(64)
        .append(t.get("id")).append(", ")
        .append(t.get("first")).append(", ")
        .append(t.get("last")).append(", ")
        .append(t.get("title")).append(", ")
        .append(t.get("status")).append(", ")
        .append(t.get("subunit"));
    System.out.println(builder.toString());
}