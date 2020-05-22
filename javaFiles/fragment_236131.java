void speechResult(String param, Consumer<String> onComplete) {
    speechOutput(params, () -> {
        speechInput(params, (result) -> {
            onComplete.accept(result);
        });
    });
}