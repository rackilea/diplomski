Iterable<Item> iterable = Arrays.asList(item2, item3);

item1.event().
        concatWith(Observable.from(iterable)
                .map(Item::act))
        .subscribe();

item1.act();