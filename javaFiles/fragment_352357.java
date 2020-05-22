public ClientResponse apply(final ClientRequest clientRequest) {
    PropertiesDelegate propertiesDelegate = new MapPropertiesDelegate();

    final ContainerRequest containerRequest = new ContainerRequest(baseUri,
            clientRequest.getUri(), clientRequest.getMethod(),
            null, propertiesDelegate);

    containerRequest.getHeaders().putAll(clientRequest.getStringHeaders());

    final ByteArrayOutputStream clientOutput = new ByteArrayOutputStream();
    if (clientRequest.getEntity() != null) {
        clientRequest.setStreamProvider(new OutboundMessageContext.StreamProvider() {
            @Override
            public OutputStream getOutputStream(int contentLength) throws IOException {
                final MultivaluedMap<String, Object> clientHeaders = clientRequest.getHeaders();
                if (contentLength != -1 && !clientHeaders.containsKey(HttpHeaders.CONTENT_LENGTH)) {
                    containerRequest.getHeaders().putSingle(HttpHeaders.CONTENT_LENGTH, String.valueOf(contentLength));
                }
                return clientOutput;
            }
        });