public static String getHttpResult(String url, String user, String password)
      throws IOException
  {

    Client client = Client.create();
    try
    {
      client.addFilter(new HTTPBasicAuthFilter(user, password));

      try
      {
        WebResource wrget = client.resource(url);
        return wrget.get(String.class);
      }
      catch (UniformInterfaceException e)
      {
        throw new IOException("Fehler beim Zugriff auf " + url + " mit User "
            + user, e);

      }
    }
    finally
    {
      if (client != null)
        client.destroy();
    }
  }