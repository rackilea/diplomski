public class NewPortFilter {
@Bean(name = "restrictFilter")
public FilterRegistrationBean<Filter> retstrictFilter(FilterConfig filterConfig) {
    Filter filter = new OncePerRequestFilter() {

        @Override
        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                FilterChain filterChain) throws ServletException, IOException {

            // get allowed url contexts
            Set<String> config = filterConfig.getConfig().get(request.getLocalPort());
            if (config == null || config.isEmpty()) {
                response.sendError(403);
            }
            boolean accepted = false;
            for (String value : config) {
                if (request.getPathInfo().startsWith(value)) {
                    accepted = true;
                    break;
                }
            }
            if (accepted) {
                filterChain.doFilter(request, response);
            } else {
                response.sendError(403);
            }
        }
    };
    FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<Filter>();
    filterRegistrationBean.setFilter(filter);
    filterRegistrationBean.setOrder(-100);
    filterRegistrationBean.setName("restrictFilter");
    return filterRegistrationBean;
}
}