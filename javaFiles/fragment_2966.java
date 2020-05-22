HttpUriRequest request = ...;

// ...

connectionsSupervisor.addRequest(request);

try (InputStream content = httpClient.execute(request).getEntity().getContent()) {
    return IOUtils.toString(content, "UTF-8");
    // or any other usage
} finally {
    connectionsSupervisor.removeRequest(request);
    // highly important!
}