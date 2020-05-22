xsw.writeStartElement("soapenv", "Envelope", "http://schemas.xmlsoap.org/soap/envelope/");
    xsw.writeNamespace("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
    xsw.writeStartElement("soapenv", "Body", "http://schemas.xmlsoap.org/soap/envelope/");
    xsw.writeStartElement("", "InitializePayment", "http://service.jaxws.blog/");
    xsw.writeDefaultNamespace("http://service.jaxws.blog/");
    xsw.writeStartElement("", "request", "http://service.jaxws.blog/");