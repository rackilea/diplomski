public class MyFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    @Override
    public void destroy()
    {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        MyServletResponseWrapper responseWrapper = new MyServletResponseWrapper((HttpServletResponse) response);
        chain.doFilter(request, responseWrapper);
        if (evaluateResponse(responseWrapper)) {
            // Send an alert
        }
    }

    private boolean evaluateResponse(MyServletResponseWrapper responseWrapper) throws IOException
    {
        String body = responseWrapper.getResponseBodyAsText();

        // Perform business logic on the body text

        return true;
    }

    private static class MyServletResponseWrapper extends HttpServletResponseWrapper
    {
        private ByteArrayOutputStream copyOutputStream;
        private ServletOutputStream wrappedOutputStream;

        public MyServletResponseWrapper(HttpServletResponse response)
        {
            super(response);
        }

        public String getResponseBodyAsText() throws IOException
        {
            String encoding = getResponse().getCharacterEncoding();
            return copyOutputStream.toString(encoding);
        }


        @Override
        public ServletOutputStream getOutputStream() throws IOException
        {
            if (wrappedOutputStream == null) {
                wrappedOutputStream = getResponse().getOutputStream();
                copyOutputStream = new ByteArrayOutputStream();
            }
            return new ServletOutputStream()
            {
                @Override
                public boolean isReady()
                {
                    return wrappedOutputStream.isReady();
                }

                @Override
                public void setWriteListener(WriteListener listener)
                {
                    wrappedOutputStream.setWriteListener(listener);
                }

                @Override
                public void write(int b) throws IOException
                {
                    wrappedOutputStream.write(b);
                    copyOutputStream.write(b);
                }

                @Override
                public void close() throws IOException
                {
                    wrappedOutputStream.close();
                    copyOutputStream.close();
                }
            };
        }
    }
}