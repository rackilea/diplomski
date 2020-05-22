HttpMessageConverterExtractor responseExtractor = new HttpMessageConverterExtractor<>(YourErrorType.class, getMessageConverters());
YourErrorType yet = (YourErrorType) responseExtractor.extractData(new ClientHttpResponse(e) {
    // TODO Implement interface. It is very simple.
    // You can get all data from the `e' variable.
    // But I think the Spring has own implementation.
});