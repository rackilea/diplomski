public class RequestAuthenticationFilter implements Filter {

    private static final Logger LOG = Logger.getLogger(RequestAuthenticationFilter.class);

    protected static final List<String> ALLOWED_URL_LIST = Arrays.asList("/login.htm", "/400.htm", "/403.htm", "/404.htm", "/405.htm", "/500.htm", "/503.htm");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse response, FilterChain filterChain) throws IOException,
        ServletException {

        HttpServletRequest request = (HttpServletRequest) req;

        HttpSession session = request.getSession(false);
        String url = (request.getRequestURI());

        if(ALLOWED_URL_LIST.contains(url) || url.endsWith(".css") || url.endsWith(".js") || url.endsWith(".png")
            || url.endsWith(".jpg") || url.endsWith(".jpeg") || url.endsWith(".ttf") || url.endsWith(".woff")
            || url.endsWith(".csv")) {

            filterChain.doFilter(request, response);
        }
        else if((null == session) || session.getAttribute("user") == null
            || StringUtils.isEmpty(((User) session.getAttribute("user")).getUsername().trim())) {

            ((HttpServletResponse) response).sendRedirect("/login.htm");
        }
        else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}