@GET
@Path("/{param}")
@Produces({MediaType.TEXT_HTML}) 
public String printMessage(@PathParam("param") String url, @Context HttpServletRequest httpRequest) throws IOException {     
    getHost(httpRequest);      
    return urlService.getResponse(url);     
}

protected String getHost(HttpServletRequest request) {
    System.out.println("getContextPath"+request.getContextPath());
    System.out.println("getRemoteHost"+request.getRemoteHost());
    System.out.println("getRequestURL"+request.getRequestURL());
    System.out.println("getRequestURI"+request.getRequestURI());    
    return request.getRequestURI();
}