List<String> list = new ArrayList<>(Arrays.asList("12","10L","10","10R","10S","10L","14L","14","8","12S"));
List<String> orderArray = new ArrayList<>(Arrays.asList("S", "R", "L"));

List<String> sortedList = list.stream()
            .sorted(Comparator.comparing(str -> Integer.parseInt(((String)str).replaceAll("[A-Z]*","")))
                    .thenComparing(str -> getAnInt(orderArray, (String) str)))
            .distinct()
            .collect(Collectors.toList());

System.out.println(sortedList);

private int getAnInt(List<String> orderArray, String str) {
    int i = orderArray.indexOf(str.substring(str.length() - 1));
    if (i == -1) return Integer.MAX_VALUE;
    return i;
}