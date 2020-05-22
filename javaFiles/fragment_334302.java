int counter = 1;
for (Node node : document.body().childNodes()) {
    if (node instanceof TextNode) {
        System.out.println(counter++ + ") " + ((TextNode) node).text().trim());
    } else if (node instanceof Element) {
        Element element = (Element) node;
        String suffix = "";
        if ("a".equals(element.tagName())) {
            suffix = " (is a link)";
        } else if ("b".equals(element.tagName())) {
            suffix = " (is bold)";
        }
        System.out.println(counter++ + ") " + element.ownText() + suffix);
    }
}