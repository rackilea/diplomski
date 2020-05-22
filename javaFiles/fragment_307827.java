try {
    SOAPConnectionFactory scf = SOAPConnectionFactory.newInstance();
    SOAPConnection conn = scf.createConnection();
    MessageFactory mf = MessageFactory.newInstance();
    SOAPMessage msg = mf.createMessage();
    SOAPPart sp = msg.getSOAPPart();

    SOAPEnvelope env = sp.getEnvelope();
    env.addNamespaceDeclaration("tns", "http://www.otrs.org/TicketConnector/");
    SOAPBody body = env.getBody();
    SOAPBodyElement dispatch = body.addBodyElement(new QName("http://www.otrs.org/TicketConnector/", "TicketCreate", "tns"));
    dispatch.addChildElement(new QName("http://www.otrs.org/TicketConnector/", "UserLogin", "tns")).addTextNode("some user login");
    dispatch.addChildElement(new QName("http://www.otrs.org/TicketConnector/", "Password", "tns")).addTextNode("some user password");

    SOAPElement tkt = dispatch.addChildElement(new QName("http://www.otrs.org/TicketConnector/", "Ticket", "tns"));
    tkt.addChildElement(new QName("http://www.otrs.org/TicketConnector/", "Title", "tns")).addTextNode("some title");
    tkt.addChildElement(new QName("http://www.otrs.org/TicketConnector/", "Queue", "tns")).addTextNode("one of your queue names");
    tkt.addChildElement(new QName("http://www.otrs.org/TicketConnector/", "Type", "tns")).addTextNode("one of your types");
    tkt.addChildElement(new QName("http://www.otrs.org/TicketConnector/", "CustomerUser", "tns")).addTextNode("some email address not customer id/name/username. Thought this could be my sys config");
    tkt.addChildElement(new QName("http://www.otrs.org/TicketConnector/", "State", "tns")).addTextNode("one of your states");
    tkt.addChildElement(new QName("http://www.otrs.org/TicketConnector/", "Priority", "tns")).addTextNode("one of your priorities");

    SOAPElement article = dispatch.addChildElement(new QName("http://www.otrs.org/TicketConnector/", "Article", "tns"));
    article.addChildElement(new QName("http://www.otrs.org/TicketConnector/", "Subject", "tns")).addTextNode("some subject");
    article.addChildElement(new QName("http://www.otrs.org/TicketConnector/", "Body", "tns")).addTextNode("some body");
    article.addChildElement(new QName("http://www.otrs.org/TicketConnector/", "ContentType", "tns")).addTextNode("text/plain; charset=utf8");

    SOAPElement dynamicField = dispatch.addChildElement(new QName("http://www.otrs.org/TicketConnector/", "DynamicField", "tns"));
    dynamicField.addChildElement(new QName("http://www.otrs.org/TicketConnector/", "Name", "tns")).addTextNode("one of your dynamic field");
    dynamicField.addChildElement(new QName("http://www.otrs.org/TicketConnector/", "Value", "tns")).addTextNode("your dynamic field value");

    dispatch.addChildElement(tkt);
    dispatch.addChildElement(article);
    dispatch.addChildElement(dynamicField);

    /* Print the request message */
    System.out.print("Request SOAP Message:");
    msg.writeTo(System.out);
    System.out.println();
    URL url = new URL("http://your otrs ip address/otrs/nph-genericinterface.pl/Webservice/GenericTicketConnectorSOAP");
    SOAPMessage resp = conn.call(msg, url);
    resp.writeTo(System.out);
    System.out.println();
    } catch (SOAPException | UnsupportedOperationException | IOException e) {
        e.printStackTrace();
    }