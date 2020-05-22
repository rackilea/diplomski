HttpServletRequest httpServletRequest = (HttpServletRequest) request;

// Proxy
String userIpAddress = httpServletRequest.getHeader("X-Forwarded-For");

if(userIpAddress == null) {
   userIpAddress = request.getRemoteAddr();
}