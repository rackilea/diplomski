import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

private String loginUri="/LoginLogout/login";
private RequestDispatcher dispatcher;

public LoginFilter() {
}

public void destroy() {
}

public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    HttpServletRequest req=(HttpServletRequest) request;
    HttpServletResponse res=(HttpServletResponse) response;
    HttpSession session=req.getSession(false);
    String reqUri=req.getRequestURI();
    System.out.println("RequestURI:"+reqUri);

    //already looged in
    if(session!=null && session.getAttribute("user")!=null){

        //trying to access login url after logged in
        if(reqUri.equals(loginUri)){
            System.out.println("you are already logged in");
            dispatcher=request.getRequestDispatcher("/home");
            dispatcher.forward(req, res);
            return;
        }
        else{
            chain.doFilter(request, response);
        }
    } 
    //if not logged-in
    else{
        System.out.println("First have to logged in");
        dispatcher=request.getRequestDispatcher("/login");
        dispatcher.forward(req, res);
        return;
    }

}

public void init(FilterConfig fConfig) throws ServletException {
}

}