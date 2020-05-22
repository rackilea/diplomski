public class AnotherHelloWorldServlet extends HttpServlet {

  private MessageService service = null;
  private BundleContext context;

  @Override
  public void init(final ServletConfig config) throws ServletException {
    super.init(config);

    context = (BundleContext) config.getServletContext().getAttribute("osgi-bundlecontext");

    final AnotherHelloWorldServlet servlet = this;

    ServiceTracker tracker = new ServiceTracker(context,
        MessageService.class.getName(), null) {

      @Override
      public Object addingService(final ServiceReference sref) {
        log.infof("Adding service: %s to %s", sref, servlet);
        service = (MessageService) super.addingService(sref);
        return service;
      }

      @Override
      public void removedService(final ServiceReference sref, final Object sinst) {
        super.removedService(sref, service);
        log.infof("Removing service: %s from %s", sref, servlet);
        service = null;
      }
    };
    tracker.open();
  }
}