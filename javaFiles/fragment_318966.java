class Response {
  private Double d;

  // getter and setter
}

@ApiMethod(name = "weather.bla")
public Response Bla()
{
  Response r = new Response();
  r.setD(2.5)
  return r;
}