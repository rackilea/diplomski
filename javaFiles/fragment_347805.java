import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class Blah implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        if(request instanceof HttpServletRequest) {
            HttpServletRequest hr = (HttpServletRequest)request;
            String lang = hr.getHeader("Accept-Language");

            String url = "the new url"; // decide where to send the person
            boolean needsForward = true; // decide wether or not to forward at all
            if(needsForward) {
                request.getRequestDispatcher(url).forward(request, response);
                return;
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }
}