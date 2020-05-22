public interface ResponseHandler<T> {
    T handleResponse(HttpURLConnection conn);
}

public <T> T sendRequest(final HttpURLConnection conn, final String content,
        final ResponseHandler<T> handler)
        throws IOException {
    OutputStream out = null;
    try {
        out = conn.getOutputStream();
        // uses platform encoding, might want to explicitly
        // specify "UTF-8"
        out.write(content.getBytes());
        out.flush();

        return handler.handleResponse(conn);
    } finally {
        // closing out omitted for brevity
    }
}