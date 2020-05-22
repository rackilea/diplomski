@ApiMethod
public MyResponse getResponse( HttpServletRequest req, @Named("infoId") String infoId ) {
    // Use 'req' as you would in a servlet, e.g.
    String ipAddress = req.getRemoteAddr();
    ...
}