class ReadableContentHttpServletResponse extends HttpServletResponseWrapper {
    private ByteArrayOutputStream outputStream;
    private ServletOutputStream servletOutputStream;



    public ReadableContentHttpServletResponse(HttpServletResponse response) throws IOException {
        super(response);

        outputStream = new ByteArrayOutputStream();
        final ServletOutputStream  responseOutputStream = response.getOutputStream();

        servletOutputStream = new ServletOutputStream() {
            private WriteListener writeListener = null;


            @Override
            public void write(int b) throws IOException {               
                outputStream.write(b);
                responseOutputStream.write(b);
                if (writeListener != null) {
                    writeListener.notify();
                }
            }


...