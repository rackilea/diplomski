package testMiscellaneous;

class Miscellaneous {
    public static String staticMember = "staticMember";

    public static String staticMethod() {
        String s = "staticMethod";

        System.out.println("public static String staticMethod() called");

        return s;
    }

    public static void main(String[] args) {
        System.out.println("public static void main(String[] args) called");
    }
}