static void dump(String[] ss) {
    for (String s: ss) {
        System.out.print("[" + s + "]");
    }
    System.out.println();
}
public static void main(String[] args) {
    String text = "a-b-c-d---";

    dump(text.split("-"));
    // prints "[a][b][c][d]"

    dump(text.split("-", 2));
    // prints "[a][b-c-d---]"

    dump(text.split("-", -1));
    // [a][b][c][d][][][]

}