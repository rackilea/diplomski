import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DelayFilter implements Filter {



 private static final String DELAY_PARAMETER = "n";


    public void destroy() {
        // TODO Auto-generated method stub

    }

    public void doFilter(ServletRequest req, ServletResponse resp,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;

        //get delay value (DELAY_PARAMETER or n) from your request
        String delay = request.getParameter(DELAY_PARAMETER);

    if (delay!=null && !"".equals(delay)) {
        Integer seconds = Integer.valueOf(delay);

            try {
                Thread.sleep(seconds*1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
}



        HttpServletResponse response = (HttpServletResponse) resp;
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        chain.doFilter(req, resp);


    }

    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

}