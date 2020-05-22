final Flux<Data> flux = WebClient.create().get().uri("uri").exchange().flatMap(data -> {
      if (data == null)
        return Mono.error(new RuntimeException());
      return Mono.just(data);

    }).retry(throwable -> throwable instanceof RuntimeException)
        .flatMap(response -> response.bodyToMono(Data.class)).flux();