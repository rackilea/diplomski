import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.ws.rs.core.MediaType;

public class EnsureJsonIsUtf8ResponseFilter implements Filter
{
    final String APPLICATION_JSON_WITH_UTF8_CHARSET = MediaType.APPLICATION_JSON + ";charset=" + java.nio.charset.StandardCharsets.UTF_8;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpServletResponse r = (HttpServletResponse) response;
        HttpServletResponse wrappedResponse = new HttpServletResponseWrapper(r) 
        {
            @Override
            public ServletOutputStream getOutputStream() throws java.io.IOException
            {
                ServletResponse response = this.getResponse();

                String ct = (response != null) ? response.getContentType() : null;
                if (ct != null && ct.toLowerCase().startsWith(MediaType.APPLICATION_JSON))
                {
                    response.setContentType(APPLICATION_JSON_WITH_UTF8_CHARSET);
                }

                return super.getOutputStream();
            }
        };

        chain.doFilter(request, wrappedResponse); 
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        // This method intentionally left blank
    }

    @Override
    public void destroy()
    {
        // This method intentionally left blank
    }
}