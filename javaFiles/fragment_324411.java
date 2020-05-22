public static int getNumber(String text){
    return Integer.parseInt(text.replaceAll("\\D", ""));
}

public static String getChars(String text){
    return text.replaceAll("\\d", "");
}

public static void main(String[] args) {
    String a = "6A";
    String b = "14T";
    String c = "S32";

    System.out.println(getNumber(a));
    System.out.println(getChars(a));
    System.out.println(getNumber(b));
    System.out.println(getChars(b));
    System.out.println(getNumber(c));
    System.out.println(getChars(c));
}