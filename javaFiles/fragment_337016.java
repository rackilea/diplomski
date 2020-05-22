public class ResponseBufferFilter implements Filter
{
public void init(FilterConfig filterConfig) throws ServletException
{
}

public void doFilter(ServletRequest request, ServletResponse response, 
   FilterChain filterChain) throws IOException, ServletException
{
    HttpServletResponse httpResponse = (HttpServletResponse)response;
    BufferResponseWrapper wrapper = new BufferResponseWrapper(httpResponse);
    filterChain.doFilter(request, resposneWrapper);
    response.getOutputStream().write(wrapper .getWrapperBytes());
}

public void destroy()
{
}

private final class BufferResponseWrapper extends HttpServletResponseWrapper
{

    MyServletOutputStream stream = new MyServletOutputStream();

    public BufferResponseWrapper(HttpServletResponse httpServletResponse)
    {
        super(httpServletResponse);
    }

    public ServletOutputStream getOutputStream() throws IOException
    {
        return stream;
    }

    public PrintWriter getWriter() throws IOException
    {
        return new PrintWriter(stream);
    }

    public byte[] getWrapperBytes()
    {
        return stream.getBytes();
    }
}

private final class MyServletOutputStream extends ServletOutputStream
{
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    public void write(int b) throws IOException
    {
        out.write(b);
    }

    public byte[] getBytes()
    {
        return out.toByteArray();
    }

}
}