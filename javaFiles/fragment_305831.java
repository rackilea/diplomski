Single<List<Item>> items = Single.just(new ArrayList<>());
items.toObservable()
            .flatMap(new Func1<List<Item>, Observable<Item>>() {
                @Override
                public Observable<Item> call(List<Item> items) {
                    return Observable.from(items);
                }
            })
            .map(new Func1<Item, Item2>() {
                @Override
                public Item2 call(Item item) {
                    return new Item2(item);
                }
            })
            .subscribeOn(//.../)
            .observeOn(//.../);