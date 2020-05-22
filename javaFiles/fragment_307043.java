public static void main(String[] args) {
    HashMap<String, String> hmap = new HashMap<>();
    HashMap<String, Float> h2map = new HashMap<>();

    hmap.put("order1", "pending");
    hmap.put("order2", "cancelled");
    hmap.put("order3", "pending");

    h2map.put("order1", 19.95f);
    h2map.put("order2", 19.95f);
    h2map.put("order3", 39.9f);

    Map<String, DoubleSummaryStatistics> grouping = hmap
            .entrySet()
            .stream()
            .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.summarizingDouble(e -> h2map.get(e.getKey()))));

    grouping.forEach((key, value) -> System.out.println(key + ": " + value.getCount() + " " + value.getSum()));
}