Random rand = new Random();
Observable<Integer> random1 = Observable.just(rand.nextInt());
Observable<List<Integer>> random2 = random1.flatMap(
    r1 -> Observable.just(r1 * rand.nextInt()),
    (r1, r2) -> Arrays.asList(r1, r2));

random2.subscribe(System.out::println);