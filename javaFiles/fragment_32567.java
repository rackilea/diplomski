URL url = new URL("http://www.mcds.co.il/YouTube/ChanelApi.asmx");


    //generate your xml 
    String data = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n" + 
            "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n" + 
            "  <soap:Body>\r\n" + 
            "    <GetChanel xmlns=\"http://tempuri.org/\">\r\n" + 
            "      <CategoryName>string</CategoryName>\r\n" + 
            "    </GetChanel>\r\n" + 
            "  </soap:Body>\r\n" + 
            "</soap:Envelope>";


    HttpURLConnection  conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("POST");
    conn.setRequestProperty("Content-Type", "text/xml");

    conn.setRequestProperty("Content-Length", Integer.toString(data.getBytes().length));
    conn.setRequestProperty("SOAPAction","\"http://tempuri.org/GetChanel\"");

    conn.setUseCaches (false);
    conn.setDoOutput(true);
    conn.setDoInput(true);

    DataOutputStream wr = new DataOutputStream (
            conn.getOutputStream ());
    wr.writeBytes(data);
    wr.flush ();
    wr.close ();

    final char[] buffer = new char[0x10000];
    StringBuilder out = new StringBuilder();
    Reader in = new InputStreamReader(conn.getInputStream(), "UTF-8");
    int read;
    do {
      read = in.read(buffer, 0, buffer.length);
      if (read>0) {
        out.append(buffer, 0, read);
      }
    } while (read>=0);
    System.out.println(out);

    //parse out