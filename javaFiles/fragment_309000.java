public static void main(String[] args) {
    String y = "0123";
    String n = "123";

    System.out.println(startByZero(y));
    System.out.println(startByZero(n));
}

public static boolean startByZero(String value) {
    return value.startsWith("0");
}