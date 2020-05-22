public static void main(String... args) {
    List<Map<String, String>> sample = populateListOfMaps();
    sample.stream()
            .collect(Collectors.groupingBy(m -> m.get("key")))
            .forEach((key, list) -> System.out.println(key + " : " + list));
}

private static List<Map<String, String>> populateListOfMaps() {
    Random rand = new Random();
    return IntStream.range(0, 10)
            .mapToObj(i -> {
                Map<String, String> someMap = new HashMap<>(2);
                someMap.put("key", "value-" + rand.nextInt(10));
                return someMap;
            })
            .collect(Collectors.toList());
}