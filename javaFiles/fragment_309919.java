@Interceptor
@Provider
@ServerInterceptor
@SecurityChecked
public class SecurityCheckInterceptor implements PreProcessInterceptor, AcceptedByMethod, PostProcessInterceptor {
    private static final Pattern PATTERN = Pattern.compile(":");
    @Context
    HttpServletRequest servletRequest;

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityCheckInterceptor.class);

    @Nullable
    @Override
    public ServerResponse preProcess(final HttpRequest request, final ResourceMethod method) throws Failure, WebApplicationException {
        final List<String> authToken = request.getHttpHeaders().getRequestHeader(AUTH_TOKEN);

        if (authToken == null || !isValidToken(authToken.get(0))) {
            final ServerResponse serverResponse = new ServerResponse();
            serverResponse.setStatus(Response.Status.UNAUTHORIZED.getStatusCode());
            return serverResponse;
        }

        return null;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean accept(final Class declaring, final Method method) {
        // return declaring.isAnnotationPresent(SecurityChecked.class);
        return method.isAnnotationPresent(SecurityChecked.class);
    }

    @Override
    public void postProcess(final ServerResponse response) {
        final String header = servletRequest.getHeader(AUTH_TOKEN);
        LOGGER.info("post-processing response " + header);
        final String authToken = TokenUtils.createToken(PATTERN.split(header)[1]);
    }
}