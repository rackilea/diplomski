@Component
public class TestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(req, resp);
        } finally {
            HttpServletResponse response = (HttpServletResponse) resp;

            response.setStatus(205);
        }
    }
}