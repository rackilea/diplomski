public class EngineServlet extends HttpServlet {

private Engine engine;

// init is the "official" place for initialisation
public void init(ServletConfig config) throws ServletException {
     super.init(config);
     engine = new Engine();
}