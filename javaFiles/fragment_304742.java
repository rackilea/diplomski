public Mono<List<Response>> aggregate(List<Object> bodies)
{
    return Flux.fromIterable(bodies)
               .flatMap(body -> send(body).onErrorResume(e -> Mono.empty()))
               .collectList();
}

private Mono<Response> send(Object body)
{
    return WEB_CLIENT.post().syncBody(body).retrieve().bodyToMono(Response.class);
}