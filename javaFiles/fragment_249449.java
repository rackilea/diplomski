SpringApplication.run(BackendApplication.class, args);
  String[] strings = {"a","b","c"};
    Flux.merge(Flux.fromArray(strings),Flux.fromArray(strings))
            .distinct()
            .map(s -> {
                System.out.println(s);
                return s;
            }).subscribe();