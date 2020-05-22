@ApiMethod(name = "weather.bla")
public Response Bla(@Named("d") Double d)
{
  Response r = new Response();
  r.setD(d)
  return r;
}