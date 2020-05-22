private static class PostponingResponseWrapper extends HttpServletResponseWrapper {

    private ByteArrayOutputStream bos;
    private ServletOutputStream outputStream;
    private StringWriter sw;
    private PrintWriter printWriter;
    private boolean usingOutputStream;
    private boolean usingWriter;

    public PostponingResponseWrapper (HttpServletResponse response) {
        super(response);
        bos = new ByteArrayOutputStream();
        outputStream = new ServletOutputStream() {
            @Override
            public void write(int b) throws IOException {
                bos.write(b);
            }
        };
        sw = new StringWriter();
        printWriter = new PrintWriter(sw);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        usingWriter = true;
        LOGGER.info("getWriter usingWriter {}, usingOutputStream {}", usingWriter, usingOutputStream);
        return printWriter;
    }

    @Override
    public void flushBuffer() throws IOException {
        LOGGER.info("flushBuffer");
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        usingOutputStream = true;
        LOGGER.info("getOutputStream usingWriter {}, usingOutputStream {}", usingWriter, usingOutputStream);
        ServletOutputStream out = new ServletOutputStream() {
            @Override
            public void write(int b) throws IOException {
                outputStream.write(b);
            }
        };
        return out;
    }

    public void finish() throws IOException {
        LOGGER.info("finish");
        if (usingWriter) {
            super.getWriter().print(sw.toString());
        } else if (usingOutputStream) {
            super.getOutputStream().write(bos.toByteArray());
        }
    }
}

public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain chain) throws IOException, ServletException {
    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
    PostponingResponseWrapper responseWrapper =
            new PostponingResponseWrapper (httpServletResponse);
    responseWrapper.addHeader("Before", "Already-Worked");
    chain.doFilter(request, responseWrapper);
    responseWrapper.addHeader("After", "And-Now-This");
    responseWrapper.finish(); // Writes the actual response
}