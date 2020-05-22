@Component
public class LogFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(LogFilter.class);

    private static final int DEFAULT_MAX_PAYLOAD_LENGTH = 1000;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, final FilterChain filterChain) throws ServletException, IOException {
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

        logRequest(request);
        filterChain.doFilter(requestWrapper, responseWrapper);
        logResponse(responseWrapper);
    }

    private void logResponse(ContentCachingResponseWrapper responseWrapper) {
            String body = "None";
            byte[] buf = responseWrapper.getContentAsByteArray();

            if (buf.length > 0) {
                int length = Math.min(buf.length, DEFAULT_MAX_PAYLOAD_LENGTH);
                try {
                    body = new String(buf, 0, length, responseWrapper.getCharacterEncoding());
                    responseWrapper.copyBodyToResponse();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        int responseStatus = responseWrapper.getStatusCode();

        boolean is4xx = String.valueOf(responseStatus).startsWith("4");
        boolean is5xx = String.valueOf(responseStatus).startsWith("5");

        if(is4xx) logger.warn("Response: statusCode: {}, body: {}", responseStatus, body);
        else if (is5xx) logger.error("Response: statusCode: {}, body: {}", responseStatus, body);
    }

    private void logRequest(HttpServletRequest request) {
        String body = "None";
        try {
            body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.warn("Incoming request {}: {}", request.getRequestURI() , body);
    }

}