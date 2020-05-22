CompletionStage<String> tokenFuture = getToken();

CompletionStage<Boolean> result = tokenFuture.thenCompose(token -> {

    WSRequest request = ws.url(url).setHeader("Authorization", "Bearer " + token);

    CompletionStage<WSResponse> response = request.post(json);

    return response.thenCompose(r -> {
        if (r.getStatus() == 201) {
            return CompletableFuture.supplyAsync(() -> true);
        } else {
            return getToken().thenCompose(t -> {
                WSRequest req = ws.url(url).setHeader("Authorization", "Bearer " + t);
                return req.post(json).thenApply(b -> b.getStatus() == 201);
            });
        }
    });

});