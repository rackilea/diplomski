public class AjaxXSSRequestWrapper extends HttpServletRequestWrapper
{

    private final ServletInputStream inputStream;

    /**
     * @param request
     */
    public AjaxXSSRequestWrapper(final HttpServletRequest request, final ServletInputStream inputStream)
    {
        super(request);
        this.inputStream = inputStream;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletRequestWrapper#getInputStream()
     */
    @Override
    public ServletInputStream getInputStream() throws IOException
    {
        return this.inputStream;
    }
}