@Component
    @ControllerAdvice
    public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint{
    ...

    @ExceptionHandler(value = { MyAccessDeniedException.class })
        public void commence(HttpServletRequest request, HttpServletResponse response, MyAccessDeniedException ex ) throws IOException {
            String json = new ObjectMapper().writeValueAsString(ex.getRequestModel());
response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().write(json);
        response.flushBuffer();
    }