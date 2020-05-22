@Controller
@RequestMapping("/error")
public class CustomErrorController extends AbstractErrorController
{
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * The global settings for this error controller.
     */
    private final ErrorProperties properties;

    /**
     * Bean constructor.
     *
     * @param properties global properties
     * @param attributes default error attributes
     */
    @Autowired
    public CustomErrorController(ErrorProperties properties, ErrorAttributes attributes)
    {
        super(attributes);

        this.properties = new ErrorProperties();
    }

    @Override
    public String getErrorPath()
    {
        return this.properties.getPath();
    }

    /**
     * Returns the configuration properties of this controller.
     *
     * @return error properties
     */
    public ErrorProperties getErrorProperties()
    {
        return this.properties;
    }

    /**
     * This function handles runtime and application errors.
     *
     * @param request the incorrect request instance
     *
     * @return error message as XML-document
     */
    @RequestMapping (produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public ResponseEntity<Object> handleError(HttpServletRequest request)
    {
        logger.trace("Catching Exception in REST API.");
        logger.debug("Using {} for exception handling." , getClass().getSimpleName());

        // original requested REST endpoint
        String endpoint = String.valueOf(request.getAttribute(RequestDispatcher.FORWARD_REQUEST_URI));
        // status code
        String code = String.valueOf(request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
        // thrown exception
        Exception ex = ((Exception) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION));

        if(ex == null) {
            ex = new RuntimeException(String.valueOf(request.getAttribute(RequestDispatcher.ERROR_MESSAGE)));
        }

        // release nested exceptions (we want source exception only)
        if(ex instanceof NestedServletException && ex.getCause() instanceof Exception) {
            ex = (Exception) ex.getCause();
        }

        // build response body
        WebErrorResponse response = new WebErrorResponse();

        response.title   = "Internal Server Error";
        response.type    = ex.getClass().getSimpleName();
        response.code    = Integer.valueOf(code);
        response.message = request.getMethod() + ": " + endpoint+"; "+ex.getMessage();

        // build response headers
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(getResponseType(request));

        // build the response
        return new ResponseEntity<>(response, headers, getStatus(request));
    }

    /*@RequestMapping (produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Map<String, Object>> handleError(HttpServletRequest request)
    {
        Boolean stacktrace = properties.getIncludeStacktrace().equals(ErrorProperties.IncludeStacktrace.ALWAYS);

        Map<String, Object> r = getErrorAttributes(request, stacktrace);

        return new ResponseEntity<Map<String, Object>>(r, getStatus(request));
    }*/

    /**
     * Extracts the response content type from the "Accept" HTTP header field.
     *
     * @param request request instance
     *
     * @return response content type
     */
    private MediaType getResponseType(HttpServletRequest request)
    {
        String accepts = request.getHeader(HttpHeaders.ACCEPT);

        // only XML or JSON allowed
        if(accepts.contains(MediaType.APPLICATION_JSON_VALUE))
            return MediaType.APPLICATION_JSON_UTF8;
        else return MediaType.APPLICATION_XML;
    }
}