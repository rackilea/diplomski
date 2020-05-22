public class RequestProcessorFactory {
  @Inject
  private PhoneService phoneService;

  public RequestProcessor createNewProcessor(Socket socket) {
    return new RequestProcessor(socket, phoneService);
  }
}