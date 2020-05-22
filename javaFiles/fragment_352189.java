import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.regex.Pattern;

@WebFilter(urlPatterns = "/*")
public class PathingFilter implements Filter {
    Pattern[] restPatterns = new Pattern[] {
            Pattern.compile("/foo.*"),
            Pattern.compile("/bar"),
    };

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            String path = ((HttpServletRequest) request).getServletPath();
            for (Pattern pattern : restPatterns) {
                if (pattern.matcher(path).matches()) {
                    String newPath = "/rest/" + path;
                    request.getRequestDispatcher(newPath)
                        .forward(request, response);
                    return;
                }
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}
}