package transfer.util;

import static org.apache.commons.lang3.StringUtils.*;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.HttpHeaders;

import org.omnifaces.filter.HttpFilter;

import transfer.business.users.entity.Roles;

@WebFilter("/api/*")
public class BasicAuthFilter extends HttpFilter {

    @Override
    public void doFilter(final HttpServletRequest request, final HttpServletResponse response, final HttpSession session, final FilterChain chain) throws ServletException, IOException {

        // insert cookie erasure here if needed

        dontCache(response);

        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (isNotBlank(authHeader)) {
            if (isValid(authHeader)) {
                chain.doFilter(wrapRequest(request, new SimplePrincipal(webHookUser, Roles.ISSUETRACKER)), response);
            } else {
                sendAuthError(response);
            }
        } else {
            sendAuthError(response);
        }
    }

    private void dontCache(final HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
    }

    private boolean isValid(final String authHeader) {
        // check credentials and return true or false
    }

    private HttpServletRequest wrapRequest(final HttpServletRequest request, final SimplePrincipal principal) {
        final HttpServletRequestWrapper wrapper = new HttpServletRequestWrapper(request) {
            @Override
            public Principal getUserPrincipal() {
                return principal;
            }

            @Override
            public String getRemoteUser() {
                return principal.getName();
            }

            @Override
            public boolean isUserInRole(final String role) {
                return principal.getRoles().contains(role);
            }
        };
        return wrapper;
    }

    private void sendAuthError(final HttpServletResponse response) throws IOException {

        response.setHeader("WWW-Authenticate", "Basic realm=\"default\"");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
}