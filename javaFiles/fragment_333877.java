public class MultiPartFormDataCleaningInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        final MediaType contentType = request.getHeaders().getContentType();
        if (contentType != null
                && MediaType.MULTIPART_FORM_DATA.getType().equals(contentType.getType())
                && MediaType.MULTIPART_FORM_DATA.getSubtype().equals(contentType.getSubtype())) {
            return execution.execute(request, stripContentTypeAndLength(body));
        }
        return execution.execute(request, body);
    }

    private byte[] stripContentTypeAndLength(byte[] body) {
        final String bodyStr = new String(body);
        final StringBuilder builder = new StringBuilder();
        try (final Scanner scanner = new Scanner(bodyStr)) {
            while (scanner.hasNextLine()) {
                final String line = scanner.nextLine();
                if (!line.startsWith("Content-Type:")
                        && !line.startsWith("Content-Length:")) {
                    builder.append(line).append("\r\n");
                }
            }
        }
        final String newBodyStr = builder.toString();
        return newBodyStr.getBytes();
    }
}