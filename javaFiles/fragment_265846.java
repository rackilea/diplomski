public static void main(String[] args) {
    callMe1(new String[] {"a", "b", "c"});
    callMe2("a", "b", "c");
    // You can also do this
    // callMe2(new String[] {"a", "b", "c"});
}
public static void callMe1(String[] args) {
    System.out.println(args.getClass() == String[].class);
    for (String s : args) {
        System.out.println(s);
    }
}
public static void callMe2(String... args) {
    System.out.println(args.getClass() == String[].class);
    for (String s : args) {
        System.out.println(s);
    }
}