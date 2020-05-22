protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {

    String from = "USD";
    String to = "EUR";

    java.net.URL url = new java.net.URL(
            "http://www.webservicex.net/CurrencyConvertor.asmx"
                    + "/ConversionRate?FromCurrency=" + from
                    + "&ToCurrency=" + to);
    java.util.Scanner sc = new java.util.Scanner(url.openStream());

    // <?xml version="1.0" encoding="utf-8"?>
    sc.nextLine();

    // <double xmlns="http://www.webserviceX.NET/">0.724</double>
    String str = sc.nextLine().replaceAll("^.*>(.*)<.*$", "$1");

    sc.close();

    Double rate = Double.parseDouble(str);
    log("Rate: " + rate);

}