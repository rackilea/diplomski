try {
  callGroovy();
} catch (RuntimeException e) {  // EDIT --- Should be Exception, RuntimeException
  if (e instanceof HTTPClientException || e.getCause() instanceof ConnectException) {
    throw e;
  }
  // log other exception...
}