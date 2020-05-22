package package;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterImplementation implements Filter
{
    public void init(FilterConfig filterConfig) throws ServletException {...}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        // if you detect an illegal request, throw an exception or return without calling chain.doFilter.
        chain.doFilter(request, response);     
    }

    public void destroy() {...}
}