byte[] initReqrepsonse = callSOAPServer(soapBodymessage );
ByteArrayInputStream bais=new ByteArrayInputStream(initReqrepsonse);
// now parse the xml as
/** Handling XML */
SAXParserFactory spf = SAXParserFactory.newInstance();
SAXParser sp = spf.newSAXParser();
XMLReader xr = sp.getXMLReader();

/** Create handler to handle XML Tags ( extends DefaultHandler ) */
// ResponseParser  is XML parser class which will parse the XML output.
ResponseParser myXMLHandler = new ResponseParser();
xr.setContentHandler(myXMLHandler);
Log.i("XML data", bais.toString());
xr.parse(new InputSource(bais));