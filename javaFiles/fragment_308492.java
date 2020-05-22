public static void main(String[] args) {
    String input = new Wrapper("original input");

    Set<Wrapper> test = new HashSet<>();

    test.add(input);

    input.setValue("modified input");

    test.stream().forEach(name -> System.out.println(name.getValue()));

    System.out.println(input.getValue());
}