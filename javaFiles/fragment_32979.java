public static void main(String[] argv) {
    System.out.println(System.getProperty("java.version"));
    System.out.println(countDepth());
    System.out.println(countDepth());
    System.out.println(countDepth());
    System.out.println(countDepth());
    System.out.println(countDepth());
    System.out.println(countDepth());
    System.out.println(countDepth());
}
static int countDepth() {
    try { return 1+countDepth(); }
    catch(StackOverflowError err) { return 0; }
}