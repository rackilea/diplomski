public class MyController {
  private final ServiceInterface serviceInterface;
  @Inject MyController(ServiceInterface serviceInterface) {
    this.serviceInterface = serviceInterface;
    Toto toto = serviceInterface.getToto();
  }
  ...
}