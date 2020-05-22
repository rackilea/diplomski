public class Servlet extends HttpServlet {

  public AtomicInteger incrementer = new AtomicInteger (0);

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ... {
    int newValue = incrementer.incrementAndGet();
    super.service(req, res);
  }
}