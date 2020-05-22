public Something getSomething() {
  client
        .post()
        .uri("PATH")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON_UTF8)
        .body(requestBody))
        .retrieve()
        .bodyToMono(BookResponse.class)
        .doOnNext(this::validateResponseStatus)