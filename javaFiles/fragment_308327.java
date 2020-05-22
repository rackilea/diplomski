@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    CapturingResponseWrapper capturingResponseWrapper = new CapturingResponseWrapper((HttpServletResponse) response);
    chain.doFilter(request, capturingResponseWrapper);
    String content = capturingResponseWrapper.getCaptureAsString(); // This uses response character encoding.
    String replacedContent = content.replaceAll("(?i)</form(\\s)*>", "<input type=\"hidden\" name=\"zval\" value=\"fromSiteZ123\"/></form>");
    response.getWriter().write(replacedContent); // Don't ever use String#getBytes() without specifying character encoding!
}