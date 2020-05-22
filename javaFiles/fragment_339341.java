public static void main(String[] args) {
    List a = new ArrayList();
    a.add(new Object());
    List<Object[]> b = a;
    ((Object) b.get(0)).toString();
}