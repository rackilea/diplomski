public class DisableGetAuthFiler extends OncePerRequestFilter {
    ...

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        filterChain.doFilter(
                new HttpServletRequestWrapper(request) {
                    @Override
                    public String getParameter(String name) {
                        if (("login".equals(name) && getQueryString().contains("login"))
                                || ("password".equals(name) && getQueryString().contains("password"))) {
                            return null;
                        } else {
                            return super.getParameter(name);
                        }
                    }
                },
                response
        );
    }
}