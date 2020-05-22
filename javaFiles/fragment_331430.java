File fXmlFile=new File("feed.xml");
DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document doc = dBuilder.parse(fXmlFile);
doc.getDocumentElement().normalize();
NodeList nList = doc.getElementsByTagName("item");
for (int temp = 0; temp < nList.getLength(); temp++) {
    Node nNode = nList.item(temp);
    Element eElement2 = (Element) nNode;
    int search = 1234;
    System.out.println("This is the value to search from my variable: " + search);
    int toTest = Integer.parseInt(eElement2.getAttribute("UnitID"));
    System.out.println("toTest is equal to: " + toTest);
    if (toTest == search) {
        System.out.println(
                "stock Number: " + eElement2.getElementsByTagName("stock_number").item(0).getTextContent());
        Element images = (Element) eElement2.getElementsByTagName("images").item(0);
        Element image1Node = (Element) images.getElementsByTagName("Image1").item(0);
        Element image2Node = (Element) images.getElementsByTagName("Image2").item(0);
        Element image3Node = (Element) images.getElementsByTagName("Image3").item(0);
        if (image1Node.getAttribute("image").equals("1")) {
            System.out.println("image1Node id attribute is 1");
        }
        if (image2Node.getAttribute("image").equals("1")) {
            System.out.println("image2Node id attribute is 1");
        }
        if (image3Node.getAttribute("image").equals("1")) {
            System.out.println("image3Node id attribute is 1");
        }
    }
}