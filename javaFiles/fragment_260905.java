@Test
        public void test() throws Exception {
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = messageFactory.createMessage();

            SOAPPart soapPart = soapMessage.getSOAPPart();
            SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
            soapEnvelope.addNamespaceDeclaration("xsd",
                    "http://www.w3.org/2001/XMLSchema");
            soapEnvelope.addNamespaceDeclaration("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance");
            soapEnvelope.addNamespaceDeclaration("bran", "BDetail");
            SOAPBody soapBody = soapEnvelope.getBody();

            SOAPElement soapElement = soapBody.addChildElement(
                    "sentIbBTyp", "bran");

            soapElement
                    .setEncodingStyle("http://schemas.xmlsoap.org/soap/encoding/");
            SOAPElement elementBankCode = soapElement.addChildElement("pBnCode");
            // added missing attribute
            QName qname = new QName("xsi:type");
            elementBankCode.addAttribute(qname, "xsd:string");

            elementBankCode.setValue("234");

            soapMessage.writeTo(System.out);
        }