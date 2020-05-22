List list = objectMapper.readValue(jsonModules, typeFactory.constructCollectionType(List.class, Object.class));
for (Object item : list) {
    System.out.println(item + " is a: " + item.getClass());
    if (!(item instanceof String)) {
        System.out.println("Not a string!");
    }
}