public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    if(SecurityContextHolder.getContext().getAuthentication() == null) {
        SecurityContextHolder.getContext().setAuthentication(this.createAuthentication((HttpServletRequest)req));
        if(this.logger.isDebugEnabled()) {
            this.logger.debug("Populated SecurityContextHolder with anonymous token: '" + SecurityContextHolder.getContext().getAuthentication() + "'");
        }
    } else if(this.logger.isDebugEnabled()) {
        this.logger.debug("SecurityContextHolder not populated with anonymous token, as it already contained: '" + SecurityContextHolder.getContext().getAuthentication() + "'");
    }

    chain.doFilter(req, res);
}