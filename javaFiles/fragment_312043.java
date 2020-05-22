Func1<Integer, Integer> m2 = i -> i % 2;
Func1<Integer, Integer> m3 = i -> i % 3;

Observable<ImmutablePair<Integer, Observable<Integer>>> g2 = 
        Observable.range(0, 5).groupBy(m2).map(g -> new ImmutablePair<>(g.getKey(), g.cache()));
Observable<ImmutablePair<Integer, Observable<Integer>>> g3 = 
        Observable.range(0, 10).groupBy(m3).map(g -> new ImmutablePair<>(g.getKey(), g.cache()));

Observable<ImmutablePair<ImmutablePair<Integer, Observable<Integer>>, ImmutablePair<Integer, Observable<Integer>>>> x1 
= g2.compose(new Cross<>(g3, ImmutablePair::new));

Observable<ImmutablePair<ImmutablePair<Integer, Observable<Integer>>, ImmutablePair<Integer, Observable<Integer>>>> x2 
= x1.filter(pair -> pair.left.getKey().equals(pair.right.getKey()));


Observable<ImmutablePair<Integer, Integer>> o = x2.flatMap(pair -> 
pair.left.right.compose(new Cross<>(pair.right.right, ImmutablePair::new)));

o.subscribe(System.out::println, Throwable::printStackTrace);