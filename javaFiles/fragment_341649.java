private void m(Collection<List<Integer>> element, int a, IntFunction<A> f) {
    for(int i=0; i < a; i++){
        List<Integer> list = element.get(i);
        SomeClass rg = new SomeClass(list, a, f.apply(i));
        int result = rg.generate();
    }
}