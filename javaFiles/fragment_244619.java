@Override
protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .antMatchers("/access-denied")
            .permitAll()
            .and()
            .authorizeRequests()
            .antMatchers("/**")
            .authenticated()
            .and()
            .exceptionHandling()
            .authenticationEntryPoint(negotiateSecurityFilterEntryPoint())
            .accessDeniedPage("/access-denied")
            .and()
            .addFilterBefore(waffleNegotiateSecurityFilter(),
                    BasicAuthenticationFilter.class);
}

public class WaffleWrapperSecurityBean extends GenericFilterBean {
    @NotNull
    private final GenericFilterBean wrappedFilter;
    public WaffleWrapperSecurityBean(GenericFilterBean filter) {
        wrappedFilter = filter;
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        try {
            wrappedFilter.doFilter(request, response, chain);
        } catch (Exception e) {
            ((HttpServletResponse) response)
                    .sendRedirect("access-denied?message="
                            + e.getLocalizedMessage());
        }
    }
    @Override
    public void destroy() {
        wrappedFilter.destroy();
    }
}
// controller code ommited