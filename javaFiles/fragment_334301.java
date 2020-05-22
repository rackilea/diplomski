public static void main(String[] args) {
    try {
        Document document = Jsoup
                .parse("<a href=\"link1\"> text child 1</a>\r\n" + "own text 1\r\n" + "<b> text child 2</b>\r\n" + "own text 2");

        handleElement(document.body());
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void handleElement(Node parent) {
    if (parent instanceof TextNode) {
        System.out.println(((TextNode) parent).text());
    }
    for (Node node : parent.childNodes()) {
        handleElement(node);
    }
}