@FunctionName("HttpExample")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", methods = {HttpMethod.GET, HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<byte[]>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");

        byte[] body = request.getBody().get();

        Map<String, String> queryParameters = request.getQueryParameters();
        String fileName = queryParameters.get("fileName");

        return request.createResponseBuilder(HttpStatus.OK).body(fileName + " -> " + new String(body)).build();
    }