@Component
public class PathUrlLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

    private final PathTokens tokens;

    @Autowired
    public PathUrlLogoutSuccessHandler(PathTokens tokens) {
        super();
        this.tokens = tokens;
    }


    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
        throws IOException, ServletException {

        setDefaultTargetUrl(getTargetUrlFromPath(request));
        setAlwaysUseDefaultTargetUrl(true);
        handle(request, response, authentication);
    }

    private String getTargetUrlFromPath(HttpServletRequest request) {
        String refererUrl = request.getHeader("Referer");
        if (tokens.isTokenInPath(refererUrl)) {
            return "/" + tokens.getTokenFromPath(refererUrl) + "_signin";
        }
        throw new PathTokenNotFoundException("Token not found in referer URL " + refererUrl + " when retrieving logoutUrl.");
    } 
}