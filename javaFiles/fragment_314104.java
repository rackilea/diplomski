public class BasicAuthenticationFilter implements Filter {

  /** Logger */
  private static final Logger LOG = LoggerFactory.getLogger(BasicAuthenticationFilter.class);

  private String username = "";

  private String password = "";

  private String realm = "Protected";

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    username = filterConfig.getInitParameter("username");
    password = filterConfig.getInitParameter("password");
    String paramRealm = filterConfig.getInitParameter("realm");
    if (StringUtils.isNotBlank(paramRealm)) {
      realm = paramRealm;
    }
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {

    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;

    String authHeader = request.getHeader("Authorization");
    if (authHeader != null) {
      StringTokenizer st = new StringTokenizer(authHeader);
      if (st.hasMoreTokens()) {
        String basic = st.nextToken();

        if (basic.equalsIgnoreCase("Basic")) {
          try {
            String credentials = new String(Base64.decodeBase64(st.nextToken()), "UTF-8");
            LOG.debug("Credentials: " + credentials);
            int p = credentials.indexOf(":");
            if (p != -1) {
              String _username = credentials.substring(0, p).trim();
              String _password = credentials.substring(p + 1).trim();

              if (!username.equals(_username) || !password.equals(_password)) {
                unauthorized(response, "Bad credentials");
              }

              filterChain.doFilter(servletRequest, servletResponse);
            } else {
              unauthorized(response, "Invalid authentication token");
            }
          } catch (UnsupportedEncodingException e) {
            throw new Error("Couldn't retrieve authentication", e);
          }
        }
      }
    } else {
      unauthorized(response);
    }
  }

  @Override
  public void destroy() {
  }

  private void unauthorized(HttpServletResponse response, String message) throws IOException {
    response.setHeader("WWW-Authenticate", "Basic realm=\"" + realm + "\"");
    response.sendError(401, message);
  }

  private void unauthorized(HttpServletResponse response) throws IOException {
    unauthorized(response, "Unauthorized");
  }

}