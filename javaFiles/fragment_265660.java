if (request instanceof HttpServletRequest)
{
    HttpServletRequest hrequest = (HttpServletRequest) request;
    String uri = hrequest.getRequestURI(); // you should be able to just use this
    String uri = hrequest.getRequestURL(); // otherwise there are more in-depth fields
}