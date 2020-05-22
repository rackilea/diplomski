MessageFactory messageFactory = MessageFactory.newInstance();
                SOAPMessage soapMessage = messageFactory.createMessage();
                SOAPPart soapPart = soapMessage.getSOAPPart();
                String serverURI = "http://ws.myweb.com/";
                SOAPEnvelope envelope = soapPart.getEnvelope();
                envelope.addNamespaceDeclaration("ws", serverURI);

                SOAPBody soapBody = envelope.getBody();
                SOAPElement soapBodyElem = soapBody.addChildElement("search", "ws");

                SOAPElement soapBodyElem11 = soapBodyElem.addChildElement("ARloginSchemaSearch");
                SOAPElement soapBodyElem1 = soapBodyElem11.addChildElement("server");
                soapBodyElem1.addTextNode("it.dev.local");

                SOAPElement soapBodyElem2 = soapBodyElem11.addChildElement("user");
                soapBodyElem2.addTextNode("Alex");

                SOAPElement soapBodyElem3 = soapBodyElem11.addChildElement("password");
                soapBodyElem3.addTextNode("password");


                SOAPElement soapBodyElem6 = soapBodyElem11.addChildElement("tcpport");
                soapBodyElem6.addTextNode("51100");

                SOAPElement soapBodyElem7 = soapBodyElem11.addChildElement("rpcqueue");
                soapBodyElem7.addTextNode("452180");

                SOAPElement soapBodyElem8 = soapBodyElem.addChildElement("search-formName");


                SOAPElement soapBodyElem9 = soapBodyElem.addChildElement("search-QueryString");

                soapBodyElem9.addTextNode("'ID'  "+'"'+params.get("id"));

                SOAPElement soapBodyElem10 = soapBodyElem.addChildElement("search-resultFieldsList");

                SOAPElement  soapBodyElem12=soapBodyElem10.addChildElement("arrayList"); 
                soapBodyElem12.addTextNode("ID");

                soapMessage.saveChanges();

                ByteArrayOutputStream out = new ByteArrayOutputStream();

                if(Validator.isNotNull(out))
                {
                    soapMessage.writeTo(out);

               }

               return soapMessage;
             }