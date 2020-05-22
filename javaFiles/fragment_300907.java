public class TestFilter implements Filter {
    private String test;

    public void init(FilterConfig cfg) {
        this.test = "TEST1234";
        System.out.println("TEST: " + this.test);

    }

    public void doFilter(
        ServletRequest request,
        ServletResponse response,
        FilterChain chain) throws IOException, ServletException {
        System.out.println("TEST: " + this.test);
    }

    public void destroy() {}
}