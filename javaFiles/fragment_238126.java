@Provides
/* NOT @Singleton */
RetryServiceCaller provideMaxRetryAttempts(@Named("config") JsonObject config) throws IOException {
    JsonObject retryDetails = config.getJsonObject("retry_details");
    return new RetryServiceCaller(retryDetails.getInteger("maxRetryAttempts"), retryDetails.getInteger("upperBoundary"), retryDetails.getInteger("lowerBoundary"),
                                  retryDetails.getLong("multiplicationFactor"), retryDetails.getInteger("timeout"), retryDetails.getInteger("increaseTimeout"));
}