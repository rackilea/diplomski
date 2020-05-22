InputStream parsingStream = new FileInputStream(file)
DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

builder.setEntityResolver(new Resolver());
Document doc = builder.parse( parsingStream );

ByteArrayOutputStream outputStream = new ByteArrayOutputStream();    
DOMImplementationLS domImplementationLS = (DOMImplementationLS)doc.getImplementation().getFeature( "LS", "3.0" );
LSOutput lsOutput = domImplementationLS.createLSOutput();
lsOutput.setByteStream( outputStream );
LSSerializer lsSerializer = domImplementationLS.createLSSerializer();
lsSerializer.write( doc, lsOutput );
byte[] byteArray = outputStream.toByteArray();


ByteArrayInputStream importStream = new ByteArrayInputStream( byteArray );
Preferences.importPreferences( importStream );