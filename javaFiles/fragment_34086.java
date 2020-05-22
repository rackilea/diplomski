public static void main(String[] args) {
    List<Map<String, Object>> myObjects = new ArrayList<>();
    Map<String, Object> myObject1 = new HashMap<>();

    myObject1.put("some attribute", 1);
    myObject1.put("some string", new String[] { "Some important information I want"});
    myObjects.add(myObject1);

    Map<String, Object> myObject2 = new HashMap<>();
    myObject2.put("some attribute", 1);
    myObject2.put("some string", new String[] { "hello", "world" });
    myObjects.add(myObject2);

    Map<String, Object> myObject3 = new HashMap<>();
    myObject3.put("some attribute", 2);
    myObject3.put("some string", new String[] { "don't", "want", "this"});
    myObjects.add(myObject3);

    Map<String, Object> myObject4 = new HashMap<>();
    myObject4.put("some string", new String[] { "this", "one", "does", "not", "have", "some attribute"});
    myObjects.add(myObject4);

    List<String> list = myObjects.stream()
            .filter(map -> map.containsKey("some attribute"))
            .filter(map -> map.get("some attribute").equals(Integer.valueOf(1)))
            .flatMap(map -> Arrays.stream((String[])map.get("some string")))
            .collect(Collectors.toList());

        System.out.println(list);
    }