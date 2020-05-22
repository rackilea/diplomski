HttpServletRequest httpRequest = (HttpServletRequest) request;
HttpServletResponse httpResponse = (HttpServletResponse) response;

HttpSession session = httpRequest.getSession(false);// don't create if it doesn't exist
if(session == null || session.isNew()) {
    httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // status code is 401
}else{
    // pass the request along the filter chain
    chain.doFilter(request, response);
}