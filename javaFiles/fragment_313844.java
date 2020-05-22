Observable<Pair<A, B>> abObservable = getAObservable()
      .flatMap(
        new Func1<A, Observable<? extends B>>() {
            @Override
            public Observable<? extends B> call(A a) {
                return getBObservable(a);
            }
        },
        new Func2<A, B, Pair<A, B>>() {
            @Override
            public Pair<A, B> call(A a1, B b1) {
                return new Pair<>(a1, b1);
            }
        }
      );