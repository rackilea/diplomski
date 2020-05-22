File input = new File("shop.xml");
SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
List<Department> departments = new ArrayList<>();
parser.parse(input, new DefaultHandler() {
    Department department = null;
    @Override
    public void startElement(String uri,
        String localName, String qName, Attributes attributes)
        throws SAXException {
        switch (qName) {
        case "department":
            department = new Department(
                attributes.getValue("number"),
                attributes.getValue("name"));
            departments.add(department);
            break;
        case "product":
            department.products.add(Integer.parseInt(attributes.getValue("id")));
            break;
        }
    }
});