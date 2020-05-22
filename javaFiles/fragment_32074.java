package mypackage.server;

public class ConfigurableRemoteLoggingServiceImpl extends RemoteLoggingServiceImpl {

  @Override
  public void init(final ServletConfig config) throws ServletException {
    super.init(config);

    final String symbolMapsDirectory = 
        config.getInitParameter("symbolMapsDirectory");
    setSymbolMapsDirectory(symbolMapsDirectory);
  }
}