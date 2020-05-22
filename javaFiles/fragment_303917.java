public static void main(String... args) {

    Document document = Jsoup
            .parse("<div><ul><li>11</li><li>22</li></ul><p>ppp<span>sp</span</p></div>");

    Element div = document.select("div").first();
    Elements divChildren = div.children();

    Elements detachedDivChildren = new Elements();
    for (Element elem : divChildren) {
        Element detachedChild = new Element(Tag.valueOf(elem.tagName()),
                elem.baseUri(), elem.attributes().clone());
        detachedDivChildren.add(detachedChild);
    }

    System.out.println(divChildren.size());
    for (Element elem : divChildren) {
        System.out.println(elem.tagName());
    }

    System.out.println("\ndivChildren content: \n" + divChildren);

    System.out.println("\ndetachedDivChildren content: \n"
            + detachedDivChildren);
}