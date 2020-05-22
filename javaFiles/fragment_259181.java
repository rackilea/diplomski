public static void main(final String[] args) {
    final Shop<String> turkey = new Shop<String>();
    turkey.sell("pork");
    turkey.sell("chicken");
    turkey.print();
    final Set<String> possessions = new HashSet<String>();
    turkey.buy(2, possessions);
    for (final String e : possessions) {
        System.out.println(e);
    }
}