@Component
public class SomeFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(SomeFilter.class);

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletRequest modifiedRequest = new SomeHttpServletRequest(request);
        filterChain.doFilter(modifiedRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

    class SomeHttpServletRequest extends HttpServletRequestWrapper {
        HttpServletRequest request;

        SomeHttpServletRequest(final HttpServletRequest request) {
            super(request);
            this.request = request;
        }

        @Override
        public String getQueryString() {
            String queryString = request.getQueryString();
            LOGGER.info("Original query string: " + queryString);

            try {
                // You need to escape all your non encoded special characters here
                String specialChar = URLEncoder.encode("%", "UTF-8");
                queryString = queryString.replaceAll("\\%\\%", specialChar + "%");

                String decoded = URLDecoder.decode(queryString, "UTF-8");
                LOGGER.info("Modified query string: "  + decoded);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            return queryString;
        }

        @Override
        public String getParameter(final String name) {
            String[] params = getParameterMap().get(name);
            return params.length > 0 ? params[0] : null;
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            String queryString = getQueryString();
            return getParamsFromQueryString(queryString);
        }

        @Override
        public Enumeration<String> getParameterNames() {
            return Collections.enumeration(getParameterMap().keySet());
        }

        @Override
        public String[] getParameterValues(final String name) {
            return getParameterMap().get(name);
        }

        private Map<String, String[]> getParamsFromQueryString(final String queryString) {
            String decoded = "";
            try {
                decoded = URLDecoder.decode(queryString, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            String[] params = decoded.split("&");
            Map<String, List<String>> collect = Stream.of(params)
                .map(x -> x.split("="))
                .collect(Collectors.groupingBy(
                    x -> x[0],
                    Collectors.mapping(
                        x -> x.length > 1 ? x[1] : null,
                        Collectors.toList())));

            Map<String, String[]> result = collect.entrySet().stream()
                .collect(Collectors.toMap(
                    x -> x.getKey(),
                    x -> x.getValue()
                        .stream()
                        .toArray(String[]::new)));

            return result;
        }
    }
}