@Post("/")
public Payload login(LoginRequest loginRequest) {
  if(!loginRequest.getPassword().equals("helloworld")) {
    return new Payload("ERROR").withCode(HttpStatus.UNAUTHORIZED);
  }

  return new Payload("SUCCESS").withCode(HttpStatus.CREATED);
}