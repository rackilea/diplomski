public WebSocket ws() {
    return WebSocket.Json.acceptOrResult(request -> {
        if (sameOriginCheck(request)) {
            final CompletionStage<Flow<JsonNode, JsonNode, NotUsed>> future = wsFutureFlow(request);
            final CompletionStage<Either<Result, Flow<JsonNode, JsonNode, ?>>> stage = future.thenApply(Either::Right);
            return stage.exceptionally(this::logException);
        } else {
            return forbiddenResult();
        }
    });
}

@SuppressWarnings("unchecked")
private CompletionStage<Flow<JsonNode, JsonNode, NotUsed>> wsFutureFlow(Http.RequestHeader request) {
    long id = request.asScala().id();
    UserParentActor.Create create = new UserParentActor.Create(Long.toString(id));

    return ask(userParentActor, create, t).thenApply((Object flow) -> {
        final Flow<JsonNode, JsonNode, NotUsed> f = (Flow<JsonNode, JsonNode, NotUsed>) flow;
        return f.named("websocket");
    });
}

private CompletionStage<Either<Result, Flow<JsonNode, JsonNode, ?>>> forbiddenResult() {
    final Result forbidden = Results.forbidden("forbidden");
    final Either<Result, Flow<JsonNode, JsonNode, ?>> left = Either.Left(forbidden);

    return CompletableFuture.completedFuture(left);
}

private Either<Result, Flow<JsonNode, JsonNode, ?>> logException(Throwable throwable) {
    logger.error("Cannot create websocket", throwable);
    Result result = Results.internalServerError("error");
    return Either.Left(result);
}