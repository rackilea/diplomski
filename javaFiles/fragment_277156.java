public Mono<ServerResponse> upload(ServerRequest request) {
    Mono<String> then = request.multipartData().map(it -> it.get("files"))
        .flatMapMany(Flux::fromIterable)
        .cast(FilePart.class)
        .flatMap(it -> it.transferTo(Paths.get("/tmp/" + it.filename())))
        .then(Mono.just("OK"));

    return ServerResponse.ok().body(then, String.class);
}