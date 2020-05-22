@Component
public class PathLoginAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {
    private final PathTokens tokens;

    @Autowired
    public PathLoginAuthenticationEntryPoint(PathTokens tokens) {
        //  LoginUrlAuthenticationEntryPoint requires a default
        super("/");
        this.tokens = tokens;
    }

    /**
     * @param request   the request
     * @param response  the response
     * @param exception the exception
     * @return the URL (cannot be null or empty; defaults to {@link #getLoginFormUrl()})
     */
    @Override
    protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response,
                                                 AuthenticationException exception) {
       return getLoginUrlFromPath(request);
    }

    private String getLoginUrlFromPath(HttpServletRequest request) {
        String requestUrl = request.getRequestURI();
        if (tokens.isTokenInPath(requestUrl)) {
            return "/" + tokens.getTokenFromPath(requestUrl) + "_signin";
        }
        throw new PathTokenNotFoundException("Token not found in request URL " + requestUrl + " when retrieving LoginUrl for login form");
    }
}