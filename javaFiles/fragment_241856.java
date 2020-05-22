public void createXML() throws IOException {

    Document document = DocumentHelper.createDocument();
    Element rootElement = document.addElement("Students");
    Element studentElement = rootElement.addElement("student").addAttribute("country", "USA");
    studentElement.addElement("id").addText("1");
    studentElement.addElement("name").addText("Peter");
    XMLWriter writer = new XMLWriter(new FileWriter("Students.xml"));
    //Note that You can format this XML document
    /*
     * FileWriter output = new FileWriter(new File("Students.xml"));
    OutputFormat format = OutputFormat.createPrettyPrint();
    XMLWriter writer = new XMLWriter(output,format);<- will fomat the output
     */

    //You can print this to the console and see what it looks like
    String xmlElement = document.asXML();
    System.out.println(xmlElement);
    writer.write(document);
    writer.close();

}