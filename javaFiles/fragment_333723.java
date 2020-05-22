public static void main(String[] args) {
    Map<String, LinkedList<Object>> map = new HashMap<>();
    LinkedList<Object> data = new LinkedList<>();
    data.add(2);
    data.add(3);
    map.put("id", data);

    data = new LinkedList<>();
    data.add("Rohit");
    data.add("Iravati");
    map.put("name", data);

    data = new LinkedList<>();
    data.add("SE");
    data.add("SSE");
    map.put("jobrole", data);

    data = new LinkedList<>();
    data.add(100);
    data.add(200);
    map.put("salary", data);

    for (int i = 0; i < map.get("id").size(); i++) {
        Object id = map.get("id").get(i);
        Object name = map.get("name").get(i);
        Object jobrole = map.get("jobrole").get(i);
        Object salary = map.get("salary").get(i);
        // TODO Use above values to create your query.
        System.out.println(id + "-" + name + "-" + jobrole + "-" + salary);
    }

}