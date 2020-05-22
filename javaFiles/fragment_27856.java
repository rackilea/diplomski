try {
    chain.doFilter(request, response);
} catch (ServletException e) {
    if (e.getRootCause() instanceof ViewExpiredException) {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        res.sendRedirect(req.getContextPath() + "/errors/session-expired.jsf");
    } else {
        throw e;
    }
}