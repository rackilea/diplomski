SAXBuilder builder = new SAXBuilder();
    File xmlFile = new File("flowmodeling.xml");
    Document document = (Document) builder.build(xmlFile);
    Element e = document.getRootElement();
    List<Element> songElements = document.getRootElement().getChildren("Flow"); 

    for(Element element : songElements) {
        Element apiName =  element.getChild("ApiName");
        System.out.println(apiName.getAttribute("name"));

        Element request = apiName.getChild("Request");
        System.out.println(request.getValue());

        Element response = apiName.getChild("Response");
        System.out.println(response.getValue());
    }