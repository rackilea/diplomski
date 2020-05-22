@Component
public class RestAuthenticationFailureHandler implements AuthenticationFailureHandler
{
  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException ex) throws IOException, ServletException
  {
    response.setStatus(HttpStatus.FORBIDDEN.value());

    Map<String, Object> data = new HashMap<>();
    data.put("timestamp", new Date());
    data.put("status",HttpStatus.FORBIDDEN.value());
    data.put("message", "Access Denied");
    data.put("path", request.getRequestURL().toString());

    OutputStream out = response.getOutputStream();
    com.fasterxml.jackson.databind.ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(out, data);
    out.flush();
  }
}