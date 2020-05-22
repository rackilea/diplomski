String example =
        "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Header /><soapenv:Body><ns2:farm xmlns:ns2=\"http://adamish.com/example/farm\"><horse height=\"123\" name=\"glue factory\"/></ns2:farm></soapenv:Body></soapenv:Envelope>";
SOAPMessage message = MessageFactory.newInstance().createMessage(null,
        new ByteArrayInputStream(example.getBytes()));
Unmarshaller unmarshaller = JAXBContext.newInstance(Farm.class).createUnmarshaller();
Farm farm = (Farm)unmarshaller.unmarshal(message.getSOAPBody().extractContentAsDocument());