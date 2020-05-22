public static void main(String[] args) {

    printTest("Van-Dame Claud");
    printTest("Victor Hugo");
    printTest("Anna");
    printTest("");

}

private static void printTest(String S) {

    System.out.printf("Reverse name for %s: %s\n", S, reverseName(S));

}