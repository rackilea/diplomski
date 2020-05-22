public static void main(String[] args) {
    String str = "row1col1 row2col2\r\nrow2col1 row2col2\r\nrow3col1 row3col2";

    MyObject[] array =
        Pattern.compile(System.lineSeparator(), Pattern.LITERAL)
               .splitAsStream(str)
               .map(s -> s.split("\\s+", 2))
               .map(a -> new MyObject(a[0], a[1]))
               .toArray(MyObject[]::new);

    System.out.println(Arrays.toString(array));
}