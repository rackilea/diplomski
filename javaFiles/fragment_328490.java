public static Request requestWithHeaders(String url, RequestBody body, List<String> headerNames, List<String> headerValues) {
    if (headerNames.size() != headerValues.size()) {
        throw new IllegalArgumentException(String.format(
            "Must provide the same number of header names and header values. "
                + "%d header names and %d header values provided",
            headerNames.size(),
            headerValues.size()));
    }

    Request.Builder builder = new Request.Builder()
        .url(url)
        .post(body);

    for (int i = 0; i < headerNames.size(); ++i) {
        builder.addHeader(headerNames.get(i), headerValues.get(i));
    }

    return builder.build();
}