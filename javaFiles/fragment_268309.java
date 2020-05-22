@Test
public void testJSOUP() {
    StringBuilder html = new StringBuilder();
    html.append("  <table>");
    html.append("    <tr>");
    html.append("     <td class=\"odd\">TW-Central</td>");
    html.append("     <td class=\"odd\">$3.9600</td>");
    html.append("     <td class=\"odd\">$3.8800</td>");
    html.append("    </tr>");
    html.append("    <tr>");
    html.append("     <td class=\"even\">Waha Row</td>");
    html.append("     <td class=\"even\">$4.9600</td>");
    html.append("     <td class=\"even\">$5.8800</td>");
    html.append("    </tr>");
    html.append("    <tr>");
    html.append("     <td class=\"odd\">White River Hub</</td>");
    html.append("     <td class=\"odd\">$4.9600</td>");
    html.append("     <td class=\"odd\">$5.8800</td>");
    html.append("    </tr>");
    html.append("  </table>");

    Document document = Jsoup.parse(html.toString());
    Elements trElements = document.select("tr");
    for (Element tableRows : trElements) {
        Elements tdElements = tableRows.select("td");
        String articleName = tdElements.get(0).text();
        String firstPrice = tdElements.get(1).text();
        String secondPrice = tdElements.get(2).text();

        System.out.println("The article: " + articleName + "has price one:" + firstPrice + " and price two:" + secondPrice);
    }
}