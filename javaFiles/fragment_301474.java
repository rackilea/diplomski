@Component
public class HealthcheckSimpleStatusFilter  extends GenericFilterBean {

private final String AUTHORIZATION_HEADER_NAME="Authorization";

private final String URL_PATH = "/health";

@Value("${healthcheck.username}")
private String username;

@Value("${healthcheck.password}")
private String password;

private String healthcheckRole="ADMIN";

@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException {
    HttpServletRequest httpRequest = this.getAsHttpRequest(request);

    //doing it only for /health endpoint.
    if(URL_PATH.equals(httpRequest.getServletPath())) {

        String authHeader = httpRequest.getHeader(AUTHORIZATION_HEADER_NAME);

        if (authHeader != null && authHeader.startsWith("Basic ")) {
            String[] tokens = extractAndDecodeHeader(authHeader);
            if (tokens != null && tokens.length == 2 && username.equals(tokens[0]) && password.equals(tokens[1])) {
                createUserContext(username, password, healthcheckRole, httpRequest);
            } else {
                throw new BadCredentialsException("Invalid credentials");
            }
        }
    }
    chain.doFilter(request, response);
}

/**
 * setting the authenticated user in Spring context so that {@link HealthMvcEndpoint} knows later on that this is an authorized user
 * @param username
 * @param password
 * @param role
 * @param httpRequest
 */
private void createUserContext(String username, String password, String role,HttpServletRequest httpRequest) {
    List<GrantedAuthority> authoritiesForAnonymous = new ArrayList<>();
    authoritiesForAnonymous.add(new SimpleGrantedAuthority("ROLE_" + role));
    UserDetails userDetails = new User(username, password, authoritiesForAnonymous);
    UsernamePasswordAuthenticationToken authentication =
        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
    SecurityContextHolder.getContext().setAuthentication(authentication);
}

private HttpServletRequest getAsHttpRequest(ServletRequest request) throws ServletException {
    if (!(request instanceof HttpServletRequest)) {
        throw new ServletException("Expecting an HTTP request");
    }
    return (HttpServletRequest) request;
}

private String[] extractAndDecodeHeader(String header) throws IOException {
    byte[] base64Token = header.substring(6).getBytes("UTF-8");

    byte[] decoded;
    try {
        decoded = Base64.decode(base64Token);
    } catch (IllegalArgumentException var7) {
        throw new BadCredentialsException("Failed to decode basic authentication token",var7);
    }

    String token = new String(decoded, "UTF-8");
    int delim = token.indexOf(":");
    if(delim == -1) {
        throw new BadCredentialsException("Invalid basic authentication token");
    } else {
        return new String[]{token.substring(0, delim), token.substring(delim + 1)};
    }
}

}