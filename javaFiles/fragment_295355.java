public static void main(String args[]) throws java.io.IOException {

    char ch, ch2;

    System.out.print("Hit a key and press Enter: ");

    ch = (char) System.in.read();

    System.out.println("Hit a second key and press Enter: ");

    ch2 = (char) System.in.read();
    int x1=ch;
    int x2 = ch2;
    System.out.println("x1="+x1+" | x2="+x2);
    if (ch == ch2) System.out.println("Same"); else System.out.println("different");
}