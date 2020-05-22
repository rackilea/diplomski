//read the xml file
    StAXOMBuilder builder = new StAXOMBuilder(xmlStreamReader);
    OMElement endPointElem = builder.getDocumentElement();


   // go though the xml elemetns and do whatever you want
    Iterator children = endPointElem.getChildElements();
    while (children.hasNext()) {
    ........................
    .......
    }