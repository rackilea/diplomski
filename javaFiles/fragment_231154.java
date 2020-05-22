public static void parenterizacao(int[][] s, int i, int j) {
    if (i == j) {
        System.out.println("M" + i);
    } else {
        System.out.println("(");
        parenterizacao(s, i, s[i-1][j-2]);
        parenterizacao(s, s[i-1][j-2] + 1, j);
        System.out.println(")");
    }
}