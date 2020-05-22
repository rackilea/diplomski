@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionFilter extends OncePerRequestFilter {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doFilterInternal(HttpServletRequest request, 
        HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    try {
        filterChain.doFilter(request, response);
    } catch (Exception ex) {
        mapper.writeValue(response.getWriter(), new ErrorInfo("something bad happened"));
        response.setContentType(MediaType.APPLICATION_JSON);
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        response.getWriter().close();
        response.getWriter().flush();
    }  
}