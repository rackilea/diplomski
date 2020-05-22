@RequestMapping("/foo")
public String foo(HttpServletRequest request,@QueryParam("foo") String foo) {
    requestContextDataService.addNamedParam("foo", foo);

    // how can I access the full URL/query params here?
    request.getRequestURL() 
    request.getQueryString() 

    return "Service is alive!!";
}