StringBuilder html = new StringBuilder();
    html.append("  <table>");
    html.append("    <tr>");
    html.append("     <td class=\"even\">Waha</td>");
    html.append("     <td class=\"even\">$3.9600</td>");
    html.append("     <td class=\"even\">$3.8800</td>");
    html.append("    </tr>");
    html.append("  </table>");

    Document document = Jsoup.parse(html.toString());
    Elements tdElements = document.select("td");
    String waha = tdElements.get(0).text();
    String firstPrice = tdElements.get(1).text();
    String secondPrice = tdElements.get(2).text();

    System.out.println("The first td content is: " + waha);
    System.out.println("The second td content (firstPrice) is: " + firstPrice);
    System.out.println("The third td content (secondPrice) is: " + secondPrice);