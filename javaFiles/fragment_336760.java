public void givenResponse(int statusCode, MediaType contentType, String bodyPath) {
        String responseBody;
        try (InputStream data = new ClassPathResource(bodyPath).getInputStream()) {
            responseBody = copyToString(data, UTF_8);
        }

        stubFor(any(urlPathEqualTo(getWireMockUri().getPath()))
                .willReturn(aResponse()
                        .withStatus(statusCode)
                        .withHeader("Content-Type", contentType.toString())
                        .withHeader("Content-Length", String.valueOf(responseBody.length()))
                        .withBody(responseBody)
                ));
    }