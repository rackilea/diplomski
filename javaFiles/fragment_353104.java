public class Main {

public static void main(String[] args) {
    String s = "X";
    int totalColumns = 4;
    int totalRow = 3;

    colums(s, totalColumns);
    rows(s, totalColumns, totalRow);
    colums(s, totalColumns);


}

private static void colums(String cs, int cc) {
    for (int i = 0; i < cc; i++) {
        System.out.print(cs);
    }

}

private static String whitespace(int tc) {
    String ws = " ";
    for (int i = 1; i < tc - 2; i++) {
        ws += " ";
    }
    return ws;
}

private static void rows(String rs, int tc, int tr) {
    System.out.println();
    for (int i = 0; i < tr - 2  ; i++) {
        System.out.println(rs + whitespace(tc) + rs);
    }
}