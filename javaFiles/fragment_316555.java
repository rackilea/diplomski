public static void main(String[] args) {
    Myclass m = new Myclass();
    Set<Myclass> set = new HashSet<>();
    set.add(m);
    System.out.println(set.contains(m));
}