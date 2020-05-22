public CompletionStage<Result> call(Context ctx) {
    Cached cacheConfiguration = this.configuration;
    String key = cacheConfiguration.key();
    Long expires = cacheConfiguration.expires();
    string region = cacheConfiguration.region();

    ...
}