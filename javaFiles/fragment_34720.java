public static void main(String[] args) {

    Pattern p = Pattern.compile("[a-zA-Z][0-9]{6}[a-zA-Z]");

    System.out.println(p.matcher("L123456X").matches()); // true
    System.out.println(p.matcher("L12345X").matches()); // false

    System.out.println(p.matcher("1234567X").matches()); // false
    System.out.println(p.matcher("A1234567X").matches()); // false
}