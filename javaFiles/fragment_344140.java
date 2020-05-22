private static String html = 
    "<input type=\"hidden\" name=\"sessionValidity\" value=\"2018-09-13T16:28:28Z\">\n" +
    "<input type=\"hidden\" name=\"shipBeforeDate\" value=\"2018-09-17\"> \n" +
    "<input type=\"hidden\" name=\"merchantReturnData\" value=\"\"> \n" +
    "<input type=\"hidden\" name=\"shopperLocale\" value=\"en_GB\"> \n" +
    "<input type=\"hidden\" name=\"skinCode\" value=\"Ce0xkMuQ\"> \n" +
    "<input type=\"hidden\" name=\"merchantSig\" value=\"X70xAkOaaAeWGxNgWnTJolmy6/FFoFaBD47IzyBYWf4=\">";

public static void main(String[] args) {
    Document doc = Jsoup.parse(html);
    doc.select("input[name$=merchantSig]").attr("value", "Ranjan");
    // and the other ones
    System.out.println(doc.html());

}