@Override
public void run()
{
  try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); BufferedWriter output = new BufferedWriter(new PrintWriter(clientSocket.getOutputStream())))
  {
    while (clientSocket.isConnected())
    {
      String req = getRequest(reader);
      setResponse(output, req);
    }
  }
  catch (IOException e)
  {
    e.printStackTrace();
  }
  finally
  {
    try
    {
      clientSocket.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}