.....
.....
NodeList nList = (NodeList)xPath.evaluate("/plist/dict/dict/dict", root, XPathConstants.NODESET);
for (int i = 0; i < nList.getLength(); ++i) {
    Element dict = (Element)nList.item(i);

    //get current TRACK ID and print
    Double trackId = (Double)xPath.evaluate("key[.='Track ID']/following-sibling::integer[1]", dict, XPathConstants.NUMBER);
    System.out.println("Track ID: " + trackId.toString());

    //get current NAME and print
    String name = (String)xPath.evaluate("key[.='Name']/following-sibling::string[1]", dict, XPathConstants.STRING);
    System.out.println("Name: " + name);

    //get further information and process as needed
    .....
    .....
}