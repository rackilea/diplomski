public static void main(String[] args) {
    String collect = new Random().ints(10, 65, 101)
                                 .mapToObj(i -> String.valueOf((char) i))
                                 .collect(Collectors.joining());

    System.out.println(collect);

}