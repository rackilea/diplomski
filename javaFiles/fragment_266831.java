import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"}, description = "Filters!")
public class MyFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final String authToken = servletRequest.getParameter("authToken");
        if (authToken != null) {
            // and token is valid ? // etc etc ...
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            // not valid
            servletResponse.getWriter().write("No Way! No Token!");
        }
    }

    @Override
    public void destroy() {
    }
}