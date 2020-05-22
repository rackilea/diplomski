public static void main(String... args) throws IOException {

    Document document = Jsoup.parse("<div>"
            + "<a href=\"#\"> I don't want this text </a>"
            + "**I want to retrieve this text**" + "</div>");

    Element a = document.select("a").first();

    Node node = a.nextSibling();
    System.out.println(node.toString());
}