public static void main(String[] args) {
    String s = "AAaabb";
    String[] array = s.split("");

    for (String string : array) {
        System.out.println(string);
    }
}