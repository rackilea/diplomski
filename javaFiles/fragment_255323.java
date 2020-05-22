switch (request.getType()) {
  case "LOGIN":
    LoginRequest req = new LoginRequest(request.getUsername(), request.getPassword());
    break;
  case "SOMEREQUEST":
    SomeRequest req = new SomeRequest(request.getParam1(), request.getParam2());
    break;
  case "OTHERREQUEST":
    OtherRequest req = new OtherRequest(request.getParam3());
    break;
}