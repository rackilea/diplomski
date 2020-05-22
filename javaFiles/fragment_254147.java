public static void main(String... args) {
    List<String> busModels = Arrays.asList( "Setra","Mercedes","Volvo","Mercedes","Skoda","Iveco","MAN",null,"Skoda","Iveco");

    Map<String, Long> collect = busModels.stream()
        .filter(Objects::nonNull)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    TreeMap<String, Long> stringLongTreeMap = new TreeMap<>(collect);

    Set<Map.Entry<String, Long>> entries = stringLongTreeMap.entrySet();

    ArrayList<Map.Entry<String, Long>> list = new ArrayList<>(entries);

    list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

    String busRanking = list.toString();

    System.out.println(busRanking);
}