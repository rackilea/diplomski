for (Node node : document.body().childNodes()) {
    if (node instanceof TextNode) {
        System.out.println(((TextNode) node).text());
    } else if (node instanceof Element) {
        System.out.println(((Element) node).ownText());
    }
}