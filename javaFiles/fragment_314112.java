// SOAP Body
    SOAPBody soapBody = envelope.getBody();

    SOAPElement soapBodyElem = soapBody.addChildElement("TCKimlikNoDogrula", "", "http://tckimlik.nvi.gov.tr/WS");

    (...)