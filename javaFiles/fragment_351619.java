public static void main(String[] args) throws Exception {
    XMLInputFactory inputFactory = XMLInputFactory.newFactory();
    Connection connection = null;
    try (InputStream stream = Files.newInputStream(Paths.get("src/main/resources/test.xml"))) {
        XMLStreamReader reader = inputFactory.createXMLStreamReader(stream);
        reader.nextTag(); // Position on root tag
        if (! reader.getLocalName().equals("import-request"))
            throw new XMLStreamException("Invalid root element: " + reader.getLocalName());
        while (reader.nextTag() == XMLStreamConstants.START_ELEMENT) {
            switch (reader.getLocalName()) {
                case "connection-settings":
                    connection = parseConnectionSettings(reader);
                    break;
                case "data":
                    if (connection == null)
                        throw new XMLStreamException("Missing <connection-settings> before <data>");
                    parseData(reader, connection);
                    break;
                default:
                    // ignore unknown content
            }
        }
    } finally {
        if (connection != null)
            connection.close();
    }
}

private static Connection parseConnectionSettings(XMLStreamReader reader) throws Exception {
    String username = null, password = null, url = null, driverClassName = null;
    while (reader.nextTag() == XMLStreamConstants.START_ELEMENT) {
        switch (reader.getLocalName()) {
            case "username":
                username = reader.getElementText();
                break;
            case "password":
                password = reader.getElementText();
                break;
            case "url":
                url = reader.getElementText();
                break;
            case "driverClassName":
                driverClassName = reader.getElementText();
                break;
            default:
                throw new XMLStreamException("Invalid element in <connection-settings>: " + reader.getLocalName());
        }
    }
    Class.forName(driverClassName);
    return DriverManager.getConnection(url, username, password);
}

private static void parseData(XMLStreamReader reader, Connection connection) throws Exception {
    while (reader.nextTag() == XMLStreamConstants.START_ELEMENT) {
        switch (reader.getLocalName()) {
            case "departments":
                processDepartments(reader, connection);
                break;
            case "employees":
                processEmployees(reader, connection);
                break;
            default:
                throw new XMLStreamException("Invalid element in <data>: " + reader.getLocalName());
        }
    }
}

private static void processDepartments(XMLStreamReader reader, Connection connection) throws Exception {
    String dept_no = reader.getAttributeValue(null, "dept_no");
    String dept_name = reader.getAttributeValue(null, "dept_name");
    if (! reader.getElementText().isEmpty())
        throw new XMLStreamException("<departments> must be empty element");
    // process here
}

private static void processEmployees(XMLStreamReader reader, Connection connection) throws Exception {
    // code here
}