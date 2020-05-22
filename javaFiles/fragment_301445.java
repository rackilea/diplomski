for (int i = 0; i < str.length; i++) {
    System.out.print(String.format("%6s", str[i]));
    if (i % 4 == 3) {
        System.out.println();
    }
}