@Get(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM)
public HttpResponse<byte[]> downloadDocument() throws IOException, URISyntaxException {
    String documentName = "SampleDocument.pdf";
    byte[] content = Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource(documentName).toURI()));
    return HttpResponse.ok(content).header("Content-Disposition", "attachment; filename=\"" + documentName + "\"");
}