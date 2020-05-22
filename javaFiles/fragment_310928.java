package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wrappers.SendErrorResponseWrapper;

@WebFilter(urlPatterns = "/*")
public class SendErrorFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        SendErrorResponseWrapper responseWrapper = new SendErrorResponseWrapper((HttpServletRequest) request, (HttpServletResponse) response);

        chain.doFilter(request, responseWrapper);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}