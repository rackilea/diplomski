@Configuration
public class FilterConfig  {
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter() {
            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                    FilterChain filterChain) throws ServletException, IOException {
                if ("POST".equals(request.getMethod())
                        && request.getContentType().equals(MediaType.APPLICATION_FORM_URLENCODED)) {
                    //Skip this filter and call the next filter in the chain.
                    filterChain.doFilter(request, response);
                } else {
                    //Continue with processing this filter.
                    super.doFilterInternal(request, response, filterChain);
                }
            }
        };
    }
}