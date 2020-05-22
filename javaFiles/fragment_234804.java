@Component
public class PathUrlAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private final PathTokens tokens;

    @Autowired
    public PathUrlAuthenticationFailureHandler(PathTokens tokens) {
        super();
        this.tokens = tokens;
    }

    /**
     * Performs the redirect or forward to the {@code defaultFailureUrl associated with this path} if set, otherwise returns a 401 error code.
     * <p/>
     * If redirecting or forwarding, {@code saveException} will be called to cache the exception for use in
     * the target view.
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                    AuthenticationException exception) throws IOException, ServletException {
        setDefaultFailureUrl(getFailureUrlFromPath(request));
        super.onAuthenticationFailure(request, response, exception);

    }

    private String getFailureUrlFromPath(HttpServletRequest request) {
        String refererUrl = request.getHeader("Referer");
        if (tokens.isTokenInPath(refererUrl)) {
            return "/" + tokens.getTokenFromPath(refererUrl) + "_signin?error=1";
        }
        throw new PathTokenNotFoundException("Token not found in referer URL " + refererUrl + " when retrieving failureUrl for login form");
    }
}