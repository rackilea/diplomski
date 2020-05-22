@Test
    public void callTest() throws IOException, JSONException, URISyntaxException {
        // Arrange
        PowerMockito.mockStatic(Request.class);
        Request requestStub = Mockito.mock(Request.class);
        Response responseStub = Mockito.mock(Response.class);
        Path path = Paths.get(getClass().getClassLoader().getResource("data.json").toURI());
        byte[] fileBytes = Files.readAllBytes(path);
        Content content = new Content(fileBytes, ContentType.APPLICATION_JSON);

        Mockito.doReturn(responseStub).when(requestStub).execute();
        Mockito.doReturn(content).when(responseStub).returnContent();
        PowerMockito.doReturn(requestStub).when(Request.class, Mockito.anyString(), "Get");

        // Act and assert
    }