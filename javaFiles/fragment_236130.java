Single<String> speechResult(String param) {
    return Single.fromEmitter(emitter -> {
        speechOutput(params, () -> {
            speechInput(params, (result) -> {
                 emitter.onSuccess(result);
            });
        });
    });
}