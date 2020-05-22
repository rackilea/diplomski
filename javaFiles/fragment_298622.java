class Three<A, B, C> {
    A a;
    B b;
    C c;
    // Getter, Setter, Constructor
  }

  public static void main(String[] args) throws Exception {
    BehaviorSubject<Integer> s = BehaviorSubject.create();
    // Three = (The value, upstream comes mills, downstream emits mills)
    s.map(i -> new Three<>(i, System.currentTimeMillis(), System.currentTimeMillis()))
        .scan((a, b) -> {
          b.setC(a.getC() + Math.max(400L, b.getB() - a.getB()));
          return b;
        })
        .concatMap(i -> Observable.just(i.getA()).delay(Math.max(0, i.getC() - System.currentTimeMillis()),
            TimeUnit.MILLISECONDS))
        .subscribe(i -> System.out.println(i + "\t" + System.currentTimeMillis()));
    s.onNext(0);
    Thread.sleep(100);
    s.onNext(1);
    Thread.sleep(200);
    s.onNext(2);
    Thread.sleep(600);
    s.onNext(3);
    Thread.sleep(2000);
    s.onNext(4);
    Thread.sleep(200);
    s.onNext(5);
    Thread.sleep(800);
    s.onNext(6);
    Thread.sleep(1000);
  }