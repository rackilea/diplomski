public class AuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter  {  

    @Autowired
    private CustomAuthenticationProvider authProvider;


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        String username = obtainUsername(request);
        String password = obtainPassword(request);

        if (username == null) {
            username = "";
        }

        if (password == null) {
            password = "";
        }

        username = username.trim();

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);

        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);

        return this.authProvider.authenticate(authRequest);
    }



    @Override
    protected String obtainPassword(HttpServletRequest request) {
        return request.getHeader("X_password");
    }

    @Override
    protected String obtainUsername(HttpServletRequest request) {
        return request.getHeader("X_username");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        Authentication auth = attemptAuthentication(httpRequest, httpResponse);
        SecurityContextHolder.getContext().setAuthentication(auth);

        chain.doFilter(request, response);

    }



}