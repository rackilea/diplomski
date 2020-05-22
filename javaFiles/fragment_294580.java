InputStream is = new FileInputStream(filePath);

SAXReader reader = new SAXReader();
org.dom4j.Document doc = reader.read(is);
is.close();
Element content = doc.getRootElement();  //this will return the root element in your xml file
List<Element> methodEls = content.elements("element"); // this will retun List of all Elements with name "element"