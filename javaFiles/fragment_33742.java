public static void main(String[] args) {
    int x;
    int y;

    x = -10 % 4; // calculates the remainder of...
    y = -10 / 4; // ... this calculation
    System.out.println("-10 /  4 = " + y + ", remainder: " + x);

    x = -10 % -4;
    y = -10 /- 4;
    System.out.println("-10 / -4 = " + y + ", remainder: " + x);

    x = 10 % -4;
    y = 10 / -4;
    System.out.println(" 10 / -4 = " + y + ", remainder: " + x);

    x = 10 % 4;
    y = 10 / 4;
    System.out.println(" 10 /  4 = " + y + ", remainder: " + x);
}