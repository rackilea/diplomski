public class ClientFactory {

  private final ApplicationRequestFactory requestFactory = GWT.create(ApplicationRequestFactory.class);

  private EventBus eventBus;

  public ClientFactory() {
   eventBus = new SimpleEventBus();
   requestFactory.initialize(eventBus);
  }

  public ApplicationRequestFactory getRequestFactory() {
    return requestFactory;
  }

}