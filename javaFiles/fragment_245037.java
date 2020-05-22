@Test
public void test() {
    Map<String, List<A>> a = new HashMap<String, List<A>>();
    Map<String, List<B>> b = new HashMap<String, List<B>>();
    Map<String, List<? extends Base>> bases = combine(a, b);
}

private Map<String, List<? extends Base>> combine(
        Map<String, ? extends List<? extends Base>> one,
        Map<String, ? extends List<? extends Base>> two) {
    Map<String, List<? extends Base>> bases = new HashMap<String, List<? extends Base>>();

    bases.putAll(one);
    bases.putAll(two);
    return bases;
}