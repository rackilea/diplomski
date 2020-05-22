public static List<String> matchFilter(List<String> list, final String match) {
    return list.stream()
        .filter(e -> e.indexOf(match) != -1)
        .collect(Collectors.toList());
}

public static void main(String[] args) {
    String match = "e";
    List<String> myList = Arrays.asList("one", "two", "three", "four");
    System.out.println(matchFilter(myList, match)); // [one, three]
}