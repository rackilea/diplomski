@Override
public RequestBody getRequestBody(final HttpServletRequest httpServletRequest) throws IOException {

    final InputStream inputStream = httpServletRequest.getInputStream();

    final byte[] requestBodyBytes = ByteStreams.toByteArray(inputStream);

    final String contentType = httpServletRequest.getContentType();

    final MediaType mediaType = MediaType.parse(contentType);

    final RequestBody requestBody = RequestBody.create(mediaType, requestBodyBytes);

    return requestBody;
}