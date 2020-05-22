// Setting content type
httpServletResponse.setContentType("you-content-type");
chain.doFilter(httpServletRequest, new HttpServletResponseWrapper(httpServletResponse) {
    @Override
    public void setContentType(final String type) {
        // Ignore any further attempts to change content type
    }
});