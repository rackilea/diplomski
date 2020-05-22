TransformerFactory transformerFactory = TransformerFactory.newInstance();
Transformer transformer = transformerFactory.newTransformer();
Source sourceContent = soapResponse.getSOAPPart().getContent();
System.out.print("\nResponse SOAP Message = ");

StringWriter sw = new StringWriter();
transformer.transform( sourceContent, new StreamResult( sw ) );

InputSource inputSource = new InputSource( new StringReader( sw.toString() ) );
XPath xpath = XPathFactory.newInstance().newXPath();

javax.xml.namespace.NamespaceContext ns = new javax.xml.namespace.NamespaceContext()
 {

    @Override
    public String getNamespaceURI(String prefix) {
        if ( "soap".equals( prefix ) )
        {
            return "http://schemas.xmlsoap.org/soap/envelope/";
        }
        else if ( "xsi".equals( prefix ) )
        {
            return "http://www.w3.org/2001/XMLSchema-instance";
        }
        else if ( "xsd".equals( prefix ) )
        {
            return "http://www.w3.org/2001/XMLSchema";
        }
        else if ( "xml".equals( prefix ) )
        {
            return javax.xml.XMLConstants.XML_NS_URI;
        }
        else if( "responsens".equals( prefix ) )
        {
            return "http://ws.cdyne.com/";
        }


        return javax.xml.XMLConstants.NULL_NS_URI;

    }

    @Override
    public String getPrefix(String namespaceURI) {
                return null;
    }

    @Override
    public Iterator<?> getPrefixes(String namespaceURI) {
                return null;
    }

 };
 xpath.setNamespaceContext(ns);
 Object obj = xpath.evaluate("//responsens:ResponseText/text()", inputSource, XPathConstants.STRING );
 if ( obj != null ) 
 { 
       String responseText = obj.toString();
       System.out.println("Response text : " + responseText);
 }

 inputSource = new InputSource( new StringReader( sw.toString() ) );
  //To get Response code:
 obj = xpath.evaluate("//responsens:ResponseCode/text()", inputSource, XPathConstants.STRING );
 if ( obj != null ) 
 { 
    String responseCode = obj.toString();
    System.out.println("Response code : " + responseCode);
 }