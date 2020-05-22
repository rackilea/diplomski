public class StopRoutePolicy extends RoutePolicySupport {

  private static final Logger LOG = LoggerFactory.getLogger(String.class);

  @Override
  public void onExchangeBegin(Route route, Exchange exchange) {
    String stop = "tcp.input";
    CamelContext context = exchange.getContext();
    if (context.getRouteStatus(stop) != null && context.getRouteStatus(stop).isStarted()) {
      try {
        exchange.getContext().getInflightRepository().remove(exchange);
        LOG.info("STOP ROUTE: {}", stop);
        context.stopRoute(stop);
      } catch (Exception e) {
        getExceptionHandler().handleException(e);
      }
    }
  }

  @Override
  public void onExchangeDone(Route route, Exchange exchange) {
    String stop = "tcp.input";
    CamelContext context = exchange.getContext();
    if (context.getRouteStatus(stop) != null && context.getRouteStatus(stop).isStopped()) {
      try {
        LOG.info("RESTART ROUTE: {}", stop);
        context.startRoute(stop);
      } catch (Exception e) {
        getExceptionHandler().handleException(e);
      }
    }
  }
}