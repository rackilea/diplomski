public static void counter(int number, int largo) {
    int space = (largo - (number * 2) - 1) / 2;
    String left = "0123456789".substring(0, number);
    String right = new StringBuilder(left).reverse().toString();
    String spaces = space > 0 ? String.format("%" + space + "s", "") : "";
    System.out.print(spaces + left + number + right + spaces);
}