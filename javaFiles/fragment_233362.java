Observable<Bar> bars = ...
Observable<Foo> foos = ...

bars
    .toMap(bar -> bar.id, bar -> bar.name)
    .flatMap(map -> 
        foos.doOnNext(foo -> {
            String name = map.get(foo.id);
            if (name != null) {
                foo.name = name;
            }
        })
    )
    .subscribe(...)