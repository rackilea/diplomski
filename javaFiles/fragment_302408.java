public class MultipleReadHttpRequest extends HttpServletRequestWrapper {
    private ByteArrayOutputStream cachedContent;

    public MultipleReadHttpRequest(HttpServletRequest request) throws IOException {
        // Read the request body and populate the cachedContent
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        // Create input stream from cachedContent
        // and return it
    }

    @Override
    public BufferedReader getReader() throws IOException {
        // Create a reader from cachedContent
        // and return it
    }
}