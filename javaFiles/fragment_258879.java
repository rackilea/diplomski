public static void main (String[] args)
{
    String text = "text11\n"
        + "text 21<p>tagged text1\n"
        + "tagged text2</p>\n"
        + "text 2";

    StringBuilder sb = new StringBuilder("<body>");
    sb.append(text);
    sb.append("</body>");
    Document doc = Jsoup.parseBodyFragment(sb.toString());
    Element body = doc.select("body");
    List<Node> children = body.childNodes();
    StringBuilder sb2 = new StringBuilder();
    for(Node n : children) {
        if(n instanceof TextNode) {
            n.text(n.getWholeText().replace("\n", "<br/>"));
        }
        sb2.append(n.toString());
    }
    System.out.println(sb2.toString());
}