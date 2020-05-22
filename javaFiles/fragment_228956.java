// create promises to get cars
    CompletableFuture<List<String>> cars1 = CompletableFuture.completedFuture(Arrays.asList("BMW", "Alfa"));
    CompletableFuture<List<String>> cars2 = CompletableFuture.completedFuture(Collections.singletonList("WV"));
    CompletableFuture<List<String>> cars3 = CompletableFuture.completedFuture(Collections.singletonList("FIAT"));

    // collect promises just for convenience
    List<CompletableFuture<List<String>>> allFutures = Arrays.asList(cars1, cars2, cars3);

    // wait until all cars will be obtained
    CompletableFuture<List<String>> listCompletableFuture =
            CompletableFuture.allOf(cars1, cars2, cars3)
            .thenApply(avoid -> allFutures  //start to collect them
                    .stream()
                    .flatMap(f -> f.join().stream()) //get List from feature. Here these cars has been obtained, therefore non blocking
                    .collect(Collectors.toList())
    );

    // there are here
    listCompletableFuture.join().forEach(System.out::println);