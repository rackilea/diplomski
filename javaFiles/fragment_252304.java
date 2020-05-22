public String validateXMLSchema() throws SAXException, IOException
{
    File folder = new File("xsdPath");
    File[] listOfFiles = folder.listFiles();
    String tempXsdFile;

    for( int i=0; i < listOfFiles.length; i++ )
    {
        if(listOfFiles[i].isFile())
        {
            tempXsdFile = listOfFiles[i].getName();

            try
            {
                SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

                Schema schema = factory.newSchema(new File(xsdPath + tempXsdFile));

                Validator validator = schema.newValidator();
                validator.validate(new StreamSource(new File("C://Users//test.xml")));
                return tempXsdFile;
            }
            catch (IOException | SAXException e)
            {
                System.out.println("ERROR: XML not well known"+ e.getMessage());
            }
        }
    }

    return null;
}