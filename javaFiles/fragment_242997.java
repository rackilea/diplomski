if ( requestDestination.contains("/url") ) {
    String referer = request.getHeader("Referer");
    if (referer != null && referer.length() > 0) {
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        httpResponse.sendRedirect(httpResponse.encodeRedirectURL(referer));
    } else {
        // just do nothing and display a blank page if there is no Referer
    }
}