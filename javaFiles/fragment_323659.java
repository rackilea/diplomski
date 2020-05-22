@Component("myfilter")
public class MyFilter implements Filter {

    public static final String DEFAULT = "default";

    public static final String SUFFIX = "_Filter";

    // Autowire all beans that implement CountryFilter, mapped by bean name
    @Autowired
    private Map<String, CountryFilter> filters;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        // Get country code from request
        Locale locale = request.getLocale();
        String countryCode = locale.getCountry().toUpperCase();

        // Format key to gey country-specific filter
        String key = countryCode + SUFFIX;

        // If bean doesn't exist for request country...
        if (!this.filters.containsKey(key)) {
            // ..fallback to default filter
            key = DEFAULT + SUFFIX;
        }

        // Get filter for country
        CountryFilter filter = this.filters.get(key);

        // Delegate to actual country (or default) filter
        boolean countinueChain = filter.doFilterForCountry(request, response);

        if (continueChain) {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}