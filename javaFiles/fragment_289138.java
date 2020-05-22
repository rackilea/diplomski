for (int i = 0; i < 27; i++) {
    char ch = (char) ('a' + i);
    if (i == 26) {
        ch = '\'';
    }
    System.out.printf("Hi%c%n", ch);
}