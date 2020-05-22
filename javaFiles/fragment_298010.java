public static void main(String[] args) {
    String equation = "1 + 2 = 3";
    for (String s : equation.split("\\+")) {
        System.out.println( s );
    }
}