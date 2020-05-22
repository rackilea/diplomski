import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class GenericResponseWrapper extends HttpServletResponseWrapper {



    public GenericResponseWrapper(final HttpServletResponse response) {
        super(response);    
    }

    @Override
    public String getHeader(String name) {
        // TODO Auto-generated method stub
        return super.getHeader(name);
    }
    @Override
    public Collection<String> getHeaderNames() {
        // TODO Auto-generated method stub
        return super.getHeaderNames();
    }
}


public class Wrapper implements Filter {

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest httpRequest = (HttpServletRequest) request;
        final HttpServletResponse httpResponse = (HttpServletResponse) response;
            final GenericResponseWrapper wrapper = new GenericResponseWrapper(httpResponse);
            wrapper.getResponse().setCharacterEncoding("UTF-8");

            chain.doFilter(request, wrapper);
}
}