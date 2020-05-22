public void testJericho() throws IOException{

    Source source=new Source(new URL("http://example.com/"));
    List<Element> elementList=source.getAllElements();
    for (Element element : elementList) {
        printElement(element);
    }

}

public void printElement(Element element) {
    List<Element> children = element.getChildElements();
    for(Element child: children) 
        printElement(child);

    System.out.println(element.getName() + " start: " + element.getBegin());
    System.out.println(element.getName() + " end: " + element.getEnd());        
}