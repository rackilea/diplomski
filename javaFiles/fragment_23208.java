public static void main(String[] args) throws Exception{

    File xmlFile = new File("C:\\test2.xml");                
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();            
    Document document = documentBuilder.parse(xmlFile);            
    NodeList list = document.getElementsByTagName("Developer");

Writer writer = new OutputStreamWriter(new FileOutputStream("pathToFile"), "UTF-8");
BufferedWriter bw = new BufferedWriter(writer);
String id, name, surname, age, line;

    for (int i = 0; i < list.getLength(); i++) {

        Node node = list.item(i);                
        if(node.getNodeType() == Node.ELEMENT_NODE){                    
            Element element = (Element) node;       
            id = element.getAttribute("Id");
            name = element.getElementsByTagName("Name").item(0).getTextContent();
            surname = element.getElementsByTagName("Surname").item(0).getTextContent();
            age = element.getElementsByTagName("Age").item(0).getTextContent();
            line = String.format("%s\t%s\t%s\t%s", id, name, surname, age);
            bw.write(line);
            bw.newLine();
            bw.flush();             
        }  }}}