public static void main(String[] args) {
    String input = "TOM DICK HARRY";

    List<String> list = Arrays.asList(input.split(" "));
    Collections.reverse(list);
    System.out.println(list.stream().collect(Collectors.joining(" ")));
}