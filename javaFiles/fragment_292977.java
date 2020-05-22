ConnectableFlux<String> flux = Flux.range(1, 10).map(n -> "Entry " + n).publish();

DangerousClass dangerousClass = new DangerousClass(3);

flux.flatMap(x -> dangerousClass.doThis(x).retry(1))
        .doOnNext(s -> System.out.println("Completed " + s))
        .subscribe();

flux.connect();