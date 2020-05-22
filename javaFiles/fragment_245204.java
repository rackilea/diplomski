Observable.interval(1, TimeUnit.SECONDS)
        .scan(new ArrayList<>(), (list, integer) -> {
            list.add(integer);
            return list;
        })
        .subscribe(list -> System.out.println(list));