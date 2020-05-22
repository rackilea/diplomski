String fieldToFiend = "Volume";

Document doc = Jsoup.connect("https://finance.yahoo.com/quote/aapl").get();

//get the root element
Element quoteSummary = doc.getElementById("quote-summary");
String value = quoteSummary.getElementsByTag("tr")
                           //iterate over the table rows inside
                           .stream()
                           //find the row with the first td/span containing the label
                           .filter(tr -> fieldToFiend.equals(tr.getElementsByTag("span").first().text()))
                           //get the 2nd td and it's span element
                           .map(tr -> tr.getElementsByTag("td")
                                        .first()
                                        .nextElementSibling()
                                        .getElementsByTag("span")
                                        .first()
                                        .text())
                           //get the first match
                           .findFirst()
                           .orElseThrow(NoSuchElementException::new);

System.out.println(value);