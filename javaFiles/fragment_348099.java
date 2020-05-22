public String consultawhois(String domain,String tld)
{
    String domquest = domain + "." + tld;
    String resultado = "";
    Socket theSocket;
    String hostname = "whois.internic.net";
    int port = 43;
    try {
      theSocket = new Socket(hostname, port, true);
      Writer out = new OutputStreamWriter(theSocket.getOutputStream());
      out.write("="+domquest + "\r\n");
      out.flush();
      DataInputStream theWhoisStream;
      theWhoisStream = new DataInputStream(theSocket.getInputStream());
      String s;
      while ((s = theWhoisStream.readLine()) != null) {
        resultado = resultado + s + "\n";
      }
    }
    catch (IOException e) {
    }

    return resultado;
}