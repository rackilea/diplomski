LanguageServiceClient createLanguage() throws IOException {
      RetrySettings retrySettings = RetrySettings.newBuilder()
            .setTotalTimeout(Duration.of(60, ChronoUnit.SECONDS))
            .setMaxAttempts(2)
            // Some other options
            .build();
      LanguageServiceSettings.Builder sb = 
            LanguageServiceSettings.newBuilder();
      sb.annotateTextSettings().setRetrySettings(retrySettings);
      return LanguageServiceClient.create(sb.build());
    }