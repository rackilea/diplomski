@Controller
public class ODataController {

    private final ODataHttpHandler handler;

    public ODataController(ODataHttpHandler handler) {
        this.handler=handler;
    }

    @RequestMapping("/path/*")
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            handler.process(req, resp);
        } catch (Exception e) {
            log.error("Server Error occurred", e);
            throw new ServletException(e);
        }
    }
}