private static String format(String number) {
    return number.substring(0, 7 + (number.contains(".") ? 1 : 0)).replaceAll("\\.$", "");
}

public static void main(String[] args) {
    System.out.println(format("1234567"));
    System.out.println(format("1.2345678"));
    System.out.println(format("1234.5678"));
    System.out.println(format("1234567.8"));
    System.out.println(format(".12345678"));
}