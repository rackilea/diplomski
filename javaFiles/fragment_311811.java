public void parseAndWriteToDatabase(String filePath) throws ParserConfigurationException, SAXException, IOException, SQLException {

    // ...
    try (Connection connection = getDataSource().getConnection();)
    {
    initParser(connection);
    saxParser.parse(file, this);
    finalizeParser(connection);               
    }
}