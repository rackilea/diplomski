final YourService service = new YourService();
final YourStub stub = service.getService();

final Map ctx = ((BindingProvider)stub).getRequestContext();

ctx.put("ws-security.username", userName);
ctx.put("ws-security.password", password);

stub.callYourMethod();