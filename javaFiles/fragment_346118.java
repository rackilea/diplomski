import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class UserRequestsIdentificationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

       if(request.getRequestURI().contains("/changePassword/") ||  request.getRequestURI().contains("/savePersonData") ) {
                //Do your required actions here

       }

        filterChain.doFilter(request, response);
    }

}