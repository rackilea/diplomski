public static void main(String[] args) throws Exception {
    String originalHtml = "<p>p1l1<br/><!--</p>-->p1l2<br><!--<p>--></br><p id=p>p2l1<br class=b>p2l2</p>";
    String text = br2nl(originalHtml);
    String newHtml = nl2br(text);

    System.out.println("-------------");
    System.out.println(text);
    System.out.println("-------------");
    System.out.println(newHtml);
}

public static String br2nl(String html) {
    Document document = Jsoup.parse(html);
    document.select("br").append("\\n");
    document.select("p").prepend("\\n\\n");
    return document.text().replace("\\n", "\n");
}

public static String nl2br(String text) {
    return text.replace("\n\n", "<p>").replace("\n", "<br>");
}