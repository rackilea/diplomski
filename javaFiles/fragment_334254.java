@WebFilter(urlPatterns = {"/*"}, description = "My delay filter ")
    public class DelayFilter implements Filter {

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {}

        @Override
        public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
            Integer seconds = 10;
            try {
                Thread.sleep(seconds * 1000);
            } catch (InterruptedException e) {
                throw new ServletException("Interrupted!");
            }
            HttpServletResponse response = (HttpServletResponse) resp;
            response.setHeader("Cache-Control", "no-cache, must-revalidate");
            chain.doFilter(req, resp);
        }

        @Override
        public void destroy() {}
    }