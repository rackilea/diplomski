public static void main(String[] args) {
    new D().m(D.class);
    new D().m((Class<String>) null);

    new DD().m(DD.class);
    new DD().m(new ArrayList<String>());
}