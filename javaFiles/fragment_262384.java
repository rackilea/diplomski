if ("http".equalsIgnoreCase(protocol)) {
    String redirectURL = "https://" + httpRequest.getServerName() + httpRequest.getRequestURI();
    httpResponse.sendRedirect(redirectURL);
} else {
    filterChain.doFilter(request, response);
}