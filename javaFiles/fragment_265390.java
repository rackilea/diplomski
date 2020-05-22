if (e.getTagName().equalsIgnoreCase("control")) {
    String name = e.getAttribute("name");
    System.out.println("It's a " + name + " control!");

    NodeList labels = e.etElementsByTagName("label");
    for (int i = 0;i<labels.getLength();i++) {
        Element labelE = (Element)labels.item(i);
        String label = labelE.getTextContent();
        //do something with the label content;
    }
    ....
    NodeList values = e.etElementsByTagName("value");
    Element valueE = (Element)values.item(0); //seems you always have only one value element
    String value = valueE.get.getTextContent();
    ...
}