private static final HttpRequest<?> HTTP_REQUEST =
      HttpRequestBuilder.createGet(YOUR_URI)
        .addDefaultHeader(HttpHeaders.CONTENT_LENGTH, "0")
        .build();

public void test(){
  System.out.println(HTTP_REQUEST.execute().getStatisCode()); // is 200
}