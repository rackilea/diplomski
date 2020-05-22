for (j1 = 1; j1 <= i1; j1++) {
    if (j1 % 2 == 0) {
        ch = (char)('a' + j1 - 1);
    } else {
        ch = (char)('A' + j1 - 1);
    }
    System.out.print(" " + ch);
}
System.out.println();