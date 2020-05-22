public class ResponseEntityErrorHandler implements ResponseErrorHandler {

  private List<HttpMessageConverter<?>> messageConverters;

  @Override
  public boolean hasError(ClientHttpResponse response) throws IOException {
    return hasError(response.getStatusCode());
  }

  protected boolean hasError(HttpStatus statusCode) {
    return (statusCode.is4xxClientError() || statusCode.is5xxServerError());
  }

  @Override
  public void handleError(ClientHttpResponse response) throws IOException {
    HttpMessageConverterExtractor<ExceptionResponse> errorMessageExtractor =
      new HttpMessageConverterExtractor(ExceptionResponse.class, messageConverters);
    ExceptionResponse errorObject = errorMessageExtractor.extractData(response);
    throw new ResponseEntityErrorException(ResponseEntity.status(response.getRawStatusCode()).headers(response.getHeaders()).body(errorObject));
  }

  public void setMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
    this.messageConverters = messageConverters;
  }
}