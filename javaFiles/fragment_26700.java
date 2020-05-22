public static void main(String[] args) {
    String s = "8.1.009.125";
    String[] strings = s.split("\\.");
    for (String string : strings) {
        if (string.startsWith("0")) {
            string = "0." + string.substring(1);
        }
        System.out.println(Double.valueOf(string));
    }

}