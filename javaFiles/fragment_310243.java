public static void main(String[] args) {
    Object o = null;
    double d = 10d;
    o = d;
    if (o instanceof Double) {
        System.out.println("instance of java.lang.Double");
    } else {
        System.out.println("not an instance of Double");
    }
    String dStr = o.toString();
    System.out.println(dStr);
}