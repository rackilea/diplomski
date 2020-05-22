class Example {
    public static void main(String[] args) {
        ArrayList<String> list =
            supplier(ArrayList::new).get(); // compile error
    }
    static <T> Supplier<T> supplier(Supplier<T> s) { return s; }
}