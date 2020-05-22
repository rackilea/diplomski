class Test1 {
    public static void main(String[] args) {
        Name m = new ExtendedName("a","b");
        Name n = new ExtendedName("a","c");
        System.out.println(m.compareTo(n));
    }
}