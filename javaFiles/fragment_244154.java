public class SigningClient implements Client {
  final Client wrapped;

  public SigningClient(Client client) {
    wrapped = client;
  }

  @Override public Response execute(Request request) {
    Request newRequest = sign(request);
    return wrapped.execute(newRequest);
  }

  private void sign(Request request) {
    // magic
  }
}