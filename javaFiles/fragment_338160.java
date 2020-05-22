@Test
   public void verifyConnectionTest_multipart() {
      try {
         // 1. Create multipart request (example with http-commons 3.1)
         PostMethod filePost = new PostMethod(url);
         Part[] parts = { new StringPart("param", "value") };
         MultipartRequestEntity request = new MultipartRequestEntity(parts, filePost.getParams());
         filePost.setRequestEntity(request);

         // 2. fixd server handle (passing the request content type)
         this.server.handle(Method.POST, "/", request.getContentType()).with(
               new HttpRequestHandler() {

                  @Override
                  public void handle(final HttpRequest request,
                                     final HttpResponse response) {
                     response.setStatusCode(200);
                     response.setContentType("text/xml");
                  }
               });

         // 3. Execute multipart request
         HttpClient client = new HttpClient();
         int status = client.executeMethod(filePost);

         // 4. Assertions
         Assert.assertEquals(200, status);

      } catch (Exception e) {
         Assert.fail(e.getMessage());
      }
   }