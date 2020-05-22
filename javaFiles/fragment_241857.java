public void readXML() throws SAXException, IOException,
        ParserConfigurationException, DocumentException {
    /*Integration with DOM 
    DOMReader reader = new DOMReader();
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = reader.read(builder.parse(new File("Students.xml")));
    */
    SAXReader readerSAX = new SAXReader();
    Document document2 = readerSAX.read(new File("Students.xml"));
    Element root = document2.getRootElement();
    Student student = null;
    List<Student> studentsList = new ArrayList<Student>();
    if (root.getName().equalsIgnoreCase("students")) {
        for (@SuppressWarnings("unchecked")
        Iterator<Student> i = root.elementIterator(); i.hasNext();) {
            Element element = (Element) i.next();
            if ("student".equalsIgnoreCase(element.getName())) {
                student = new Student();
                for (int j = 0, size = element.nodeCount(); j < size; j++) {
                    Node node = (Node) element.node(j);
                    if (node instanceof Element) {
                        if ("id".equalsIgnoreCase(node.getName())) {
                            student.setId(Integer.parseInt(node.getText()));
                        } else if ("name".equalsIgnoreCase(node.getName())) {
                            student.setName(node.getText());
                        }
                    }
                }
                studentsList.add(student);
            }
        }
    }
    for(Student stud : studentsList){
        System.out.println(stud);           
    }
}