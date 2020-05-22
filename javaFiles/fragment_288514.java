public static void main(String[] args) throws Exception {

    String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n" +
            "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n" +
            "  <soap:Body>\r\n" +
            "    <ConversionRate xmlns=\"http://www.webserviceX.NET/\">\r\n" +
            "      <FromCurrency>USD</FromCurrency>\r\n" +
            "      <ToCurrency>CNY</ToCurrency>\r\n" +
            "    </ConversionRate>\r\n" +
            "  </soap:Body>\r\n" +
            "</soap:Envelope>";

    Authenticator.setDefault(new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("username", "password".toCharArray());
        }
    });

    URL url = new URL("http://www.webservicex.net/CurrencyConvertor.asmx");
    URLConnection  conn =  url.openConnection();
    conn.setDoOutput(true);
    conn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
    conn.setRequestProperty("SOAPAction", "http://www.webserviceX.NET/ConversionRate");

    // Send the request XML
    OutputStream outputStream = conn.getOutputStream();
    outputStream.write(xml.getBytes());
    outputStream.close();

    // Read the response XML
    InputStream inputStream = conn.getInputStream();
    Scanner sc = new Scanner(inputStream, "UTF-8");
    sc.useDelimiter("\\A");
    if (sc.hasNext()) {
        System.out.print(sc.next());
    }
    sc.close();
    inputStream.close();

}