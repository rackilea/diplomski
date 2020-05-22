public WriteToXML(File xml,String tag,List candidates )
{
    try {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setValidating(false);
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.parse(new FileInputStream(new File(xml)));
    Element element =  doc.getDocumentElement();
    NodeList node1 = doc.getElementsByTagName(tag);
    Element fn= (Element) node1.item(0);
    for (int i=0;i<candidates.size();i++) { 
        Text text = doc.createTextNode(candidates.get(i)+"\n");
        fn.appendChild(text);
    }
    printtoXML(doc);
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}