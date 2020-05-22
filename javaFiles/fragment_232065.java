static class FiveHundredFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        response.setStatus(500);
        response.getWriter().write("TEST FILTER CHAIN");
    }
}