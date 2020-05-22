public class RemoteLoggingDeobfuscatorServlet extends RemoteLoggingServiceImpl {
  public void init() throws ServletException {
    super.init();
    // replace gwt_test with your module name
    String symbols = getServletContext().getRealPath("WEB-INF/deploy/gwt_test/symbolMaps/");
    super.setSymbolMapsDirectory(symbols);
  }
}