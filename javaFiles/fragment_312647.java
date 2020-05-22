public class AuthExceptionEntryPoint implements AuthenticationEntryPoint
{
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException arg2) throws IOException, ServletException
    {
        final Map<String, Object> mapBodyException = new HashMap<>() ;

        mapBodyException.put("error"    , "Error from AuthenticationEntryPoint") ;
        mapBodyException.put("message"  , "Message from AuthenticationEntryPoint") ;
        mapBodyException.put("exception", "My stack trace exception") ;
        mapBodyException.put("path"     , request.getServletPath()) ;
        mapBodyException.put("timestamp", (new Date()).getTime()) ;

        response.setContentType("application/json") ;
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED) ;

        final ObjectMapper mapper = new ObjectMapper() ;
        mapper.writeValue(response.getOutputStream(), mapBodyException) ;
    }
}