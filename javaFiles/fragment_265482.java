static void f(char ch) {
    System.out.println("f(char)");
}
static void f(int i) {
    System.out.println("f(int)");
}
public static void main(String[] args) {
    char ch = 'X';
    f( (char)  ch + 1  ); // prints "f(int)"
    f( (char) (ch + 1) ); // prints "f(char)"
}