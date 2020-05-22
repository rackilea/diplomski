WebClient client = WebClient.builder().filter((request, next) -> next.exchange(request)
                .map(response -> {
                    MyClientHttpResponseDecorator decorated = new 
                        MyClientHttpResponseDecorator(response); 
                    return decorated;
                })).build();

class MyClientHttpResponseDecorator extends ClientHttpResponseDecorator {

  private final HttpHeaders httpHeaders;

  public MyClientHttpResponseDecorator(ClientHttpResponse delegate) {
    super(delegate);
    this.httpHeaders = new HttpHeaders(this.getDelegate().getHeaders());
    // mutate the content-type header when necessary
  }

  @Override
  public HttpHeaders getHeaders() {
    return this.httpHeaders;
  }
}