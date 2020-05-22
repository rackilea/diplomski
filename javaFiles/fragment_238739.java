@Component
public class SendErrorCustomFilter extends SendErrorFilter {

    private static final Logger LOG = LoggerFactory.getLogger(SendErrorCustomFilter.class);
    private static final String SERVLET_ERROR_STATUS_CODE = "javax.servlet.error.status_code";
    private static final String SERVLET_ERROR_EXCEPTION = "javax.servlet.error.exception";
    private static final String SERVLET_ERROR_MESSAGE = "javax.servlet.error.message";

    @Value("${error.path:/error}")
    private String errorPath;

    @Override
    public Object run() {
        try {
            RequestContext ctx = RequestContext.getCurrentContext();
            ExceptionHolder exception = findZuulException(ctx.getThrowable());
            HttpServletRequest request = ctx.getRequest();
            Throwable cause = exception.getThrowable().getCause();
            int statusCode = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;

            if (causeIsIOError(cause)) {
                statusCode = HttpServletResponse.SC_CONFLICT;
            } else if (causeIsAuthorizationError(cause)) {
                statusCode = HttpServletResponse.SC_UNAUTHORIZED;
            }

            request.setAttribute(SERVLET_ERROR_STATUS_CODE, statusCode);

            LOG.warn("Error during filtering", cause);
            request.setAttribute(SERVLET_ERROR_EXCEPTION, cause);

            if (StringUtils.hasText(exception.getErrorCause())) {
                request.setAttribute(SERVLET_ERROR_MESSAGE, cause.getMessage());
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(this.errorPath);
            if (dispatcher != null) {
                ctx.set(SEND_ERROR_FILTER_RAN, true);
                if (!ctx.getResponse().isCommitted()) {
                    ctx.setResponseStatusCode(exception.getStatusCode());
                    dispatcher.forward(request, ctx.getResponse());
                }
            }

        } catch (Exception ex) {
            ReflectionUtils.rethrowRuntimeException(ex);
        }
        return null;
    }

    private boolean causeIsIOError(Throwable cause) {
        return cause instanceof InvalidTokenPayloadException
                || cause instanceof InvalidResponseBodyException;
    }

    public boolean causeIsAuthorizationError(Throwable cause) {
        return cause instanceof InvalidJWTTokenException ||
                cause instanceof NoPermissionForResourceException ||
                cause instanceof MissingAuthorizationHeaderException;
    }