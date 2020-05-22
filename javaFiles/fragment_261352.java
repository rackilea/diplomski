XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        inputFactory.setProperty(XMLInputFactory.IS_COALESCING, true);
        InputStream in = new ByteArrayInputStream(response.getBytes());
        XMLStreamReader xr = inputFactory.createXMLStreamReader(in);
        while (xr.hasNext()) {
            int next = xr.next();
            if (next == XMLStreamConstants.START_ELEMENT) {
                if (xr.getLocalName().equals("BinaryObject")) {
                    String mimeCode = xr.getAttributeValue(null, "mimeCode");
                    if (mimeCode.equals("text/xml")) {
                        xr.next();
                    // for efficiency we can access xr inner buffer chars directly
                    char[] b = xr.getTextCharacters();
                    int textStart = xr.getTextStart();
                    int textLength = xr.getTextLength();
                    // or simply get it as String  
                    String text = xr.getText();
                    // in this example I will use JDK's internal decoder com.sun.org.apache.xerces.internal.impl.dv.util.Base64                     
                    byte[] bytes = new Base64().decode(text);

                    }
                }
            }
        }