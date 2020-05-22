@Test
public void duplicates() throws Exception {
    Observable<Integer> just = Observable.just(1, 2, 3);
    Observable<Integer> just1 = Observable.just(2, 3, 4);

    Observable.concat(just, just1).test()
            .assertResult(1, 2, 3, 2, 3, 4);
}

@Test // Filters duplicates
public void duplicatesFilter() throws Exception {
    Observable<Integer> just = Observable.just(1, 2, 3);
    Observable<Integer> just1 = Observable.just(2, 3, 4);

    Observable.concat(just, just1)
            .distinct()
            .test()
            .assertResult(1, 2, 3, 4);
}