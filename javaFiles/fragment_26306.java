class A {
    private static class SClass{
        String s;
        String t;
    }

    private static SClass sc;

    static {
        sc = new SClass();
        sc.s = "StringTest";
        System.out.println(sc.s);
    }
}