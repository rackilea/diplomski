public static void main(String[] args) {
    List<String> a1 = Arrays.asList("v1", "route1", "1.4", "destination1");
    List<String> a2 = Arrays.asList("v1", "route2", "2.3", "destination1");
    List<String> a3 = Arrays.asList("v2", "route2", "3.0", "destinationx");
    List<String> a4 = Arrays.asList("v1", "route3", "1.2", "destination2");
    List<String> a5 = Arrays.asList("v1", "route4", "3.4", "destination2");
    List<List<String>> all = List.of(a1, a2, a3, a4, a5);
    List<String> str = all.stream().filter(l -> "v1".equals(l.get(0)))
            .map(l -> {
                double v = Double.parseDouble(l.get(2)) + Double.parseDouble(a5.get(2));
                return String.format("%s,%s,%s,%s,%s,%1.1f", l.get(0), l.get(1), l.get(3), "route4", a5.get(3), v);
            })
            .collect(Collectors.toList());
    str.forEach(System.out::println);
}