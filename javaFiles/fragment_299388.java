byte[] encoded = Files.readAllBytes(Paths.get("C:\\Users\\timofb\\Documents\\test.txt"));
    String soapXml = new String(encoded, StandardCharsets.UTF_8);
    SOAPConnectionFactory soapConnectionFactory =
            SOAPConnectionFactory.newInstance();
    java.net.URL endpoint = new URL("http://" + ip + "/cs-repository/services/xds-iti41");
    SOAPConnection connection = soapConnectionFactory.createConnection();
    MessageFactory factory = MessageFactory.newInstance();
    SOAPMessage message = factory.createMessage(new MimeHeaders(), new ByteArrayInputStream(encoded));
    AttachmentPart attachment = message.createAttachmentPart();
    attachment.setContent("sm_content", "text/plain");
    attachment.setContentId("1.9f910338bf0cac0e783bfdec7e53be9237684caa8f8f4e6d@apache.org");
    message.addAttachmentPart(attachment);
    SOAPMessage response = connection.call(message, endpoint);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    response.writeTo(out);
    String strMsg = new String(out.toByteArray());
    return strMsg;