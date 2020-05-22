String htmlString = "<html><div><p><strong>\"notClickable1\"<a rel=\"nofollow\" target=\"_blank\" href=\"example1.com\">clickable</a>\"notClickable2\"<a rel=\"nofollow\" target=\"_blank\" href=\"example2.com\">clickable</a>\"notClickable3\"<a rel=\"nofollow\" target=\"_blank\" href=\"example3.com\">clickable</a></strong></p></div></html>";

Document doc = Jsoup.parse(htmlString); //can be replaced with Jsoup.connect("yourUrl").get();
String parsedHTML = "";

Element container = doc.select("div>p>strong").first();

for (Node node : container.childNodes()) {
    if(node.nodeName().equals("a") && node.previousSibling().nodeName().equals("#text")){
        parsedHTML += node.previousSibling().toString().replaceAll("\"", "");
        parsedHTML += "= " + node.attr("href").toString() + " ";
    }
}
parsedHTML.trim();

System.out.println(parsedHTML);