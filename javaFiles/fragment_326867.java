public static void main(String[] args) {
    String[] test = { "one", "two", "three", "four", "five" };

    // Move "five" to index 2
    moveLastup(test, 2);

    // [one, two, five, three, four]
    System.out.println(Arrays.toString(test));
}