try 
    {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();

        Document doc = db.parse( new File( "soapResponse.xml" ) );

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();
        javax.xml.namespace.NamespaceContext ns = new javax.xml.namespace.NamespaceContext()
        {

            @Override
            public String getNamespaceURI(String prefix) 
            {
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
                else if ( "parentns".equals( prefix ) )
                {
                    return "urn:JadeWebServices/NetsuiteCustomer/";
                }

                return javax.xml.XMLConstants.NULL_NS_URI;
           }

           @Override
           public String getPrefix(String namespaceURI) 
           {
              return null;
           }

            @Override
            public Iterator<?> getPrefixes(String namespaceURI) 
            {
                return null;
            }

        };


         xpath.setNamespaceContext(ns);
         XPathExpression expr = xpath.compile( "/soap:Envelope/soap:Body/parentns:addParentResponse/parentns:addParentResult/text()" );


         Object exprEval = expr.evaluate( doc, XPathConstants.STRING );
         if ( exprEval != null )
         {
            System.out.println( "The text of addParentResult is : " + exprEval );
         }
    }
    catch ( Exception e )
    {
        e.printStackTrace();
    }
 }