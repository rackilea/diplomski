Flux<Car> flux1 = Flux.interval(Duration.ofMillis(250)).map(i -> new Car(i));

        WebClient client = WebClient.create("http://localhost:8080");
        Disposable disposable = flux1
                // 1
                .window(5)
                .flatMap(windowedFlux -> client
                        .post()
                        .uri("/cars")
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(windowedFlux, Car.class)
                        .exchange()
                        // 2
                        .doOnNext(response -> System.out.println(response.statusCode()))
                        .flatMap(response -> response.bodyToMono(...)))
                .subscribe();

        Thread.sleep(10000);

        // 3
        disposable.dispose();