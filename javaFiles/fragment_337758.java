DefaultHttpClient htc = getHttpClient();
htc.setRedirectHandler(new RedirectHandler() {
  @Override
  public boolean isRedirectRequested(HttpResponse response, HttpContext context)
  {
    Log.d(TAG, "isRedirectRequested, response: " + response.toString());
    return false;
  }

  @Override
  public URI getLocationURI(HttpResponse response, HttpContext context)
      throws ProtocolException
  {
    Log.d(TAG, "getLocationURI, response: " + response.toString());
    return null;
  }
});
HttpResponse resp = null;
StringBuilder out = new StringBuilder();
try
{
  HttpGet get = new HttpGet(spec);
  resp = htc.execute(get);
  for (Header hdr : resp.getAllHeaders())
    Log.d(TAG, "header " + hdr.getName() + " -> " + hdr.getValue());
  ...
}
catch (Exception e)
{
  Log.e(TAG, "Error connecting to " + spec, e);
  return null;
}