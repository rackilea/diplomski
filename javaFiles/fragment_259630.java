private <S,U> void iterateSimultaneously(Collection<S> c1, Collection<U> c2, BiConsumer<Tuple<S, U>, Integer> f) {
        int i = 0
        Iterator<S> it1 = c1.iterator()
        Iterator<U> it2 = c2.iterator()
        while(it1.hasNext() && it2.hasNext()) {
            Tuple<S, U> tuple = new Tuple<>(it1.next(), it2.next())             
            f.accept(tuple, i);
            i++
        }
}
iterateSimultaneously(c1, c2, (t, i) -> {
    //stuff
})