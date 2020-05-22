@Service
public class CustomUrlRewriteFilter extends UrlRewriteFilter {

    @Autowired
    private RedirectService redirectService;

    private UrlRewriter urlRewriter;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        super.init(filterConfig);
    }

    @Override
    protected UrlRewriter getUrlRewriter(ServletRequest request, ServletResponse response, FilterChain chain) {
        return urlRewriter;
    }

    @PostConstruct
    public void initUrlRewriter() {

        List<Redirect> redirects = redirectService.retrieveAll();

        Conf conf = new Conf();

        for (Redirect redirect : redirects) {
            CustomRule rule = new CustomRule(
                    redirect.getRedirectType(), redirect.getMatchType(), redirect.getPath(), redirect.getTarget()
            );
            conf.addRule(rule);
        }

        conf.setUseQueryString(true);

        conf.initialise();

        urlRewriter = new UrlRewriter(conf);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException,
                                                                                             ServletException {
        super.doFilter(req, resp, chain);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

}