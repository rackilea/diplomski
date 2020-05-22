public static String notReplace(String s){
    return s.replaceAll("is","is not");
}

public static void main(String[] args) {
    String oldValue = "is it";
    String newValue = notReplace(oldValue);
}