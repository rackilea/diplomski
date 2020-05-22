final ServletOutputStream outputStream = new ServletOutputStream() {
    public void write(int b) throws IOException {
        outputBuffer.append((char) b);
    }
};

SlingHttpServletResponseWrapper responseWrapper = new SlingHttpServletResponseWrapper(response) {
    public ServletOutputStream getOutputStream() {
        return outputStream;
    }

    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(outputBuffer);
    }

    public SlingHttpServletResponse getSlingResponse() {
        return super.getSlingResponse();
    }
};