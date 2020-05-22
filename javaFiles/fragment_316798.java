@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalWrapFilter implements Filter {

@Override
public void init(FilterConfig filterConfig) throws ServletException {
}

@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    MultiReadRequest wrapper = new MultiReadRequest((HttpServletRequest) request);
    chain.doFilter(wrapper, response);
}

@Override
public void destroy() {
}

class MultiReadRequest extends HttpServletRequestWrapper {

    private String requestBody;

    public MultiReadRequest(HttpServletRequest request) {
        super(request);
        try {
            requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(requestBody.getBytes());
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return byteArrayInputStream.available() == 0;
            }

            @Override
            public boolean isReady() {
                return true;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }
        };
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.getInputStream(), Charset.forName("UTF-8")));
    }
}