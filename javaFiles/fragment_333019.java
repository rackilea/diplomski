SOAPMessage message = getSoapMessageFromString(foo);

        List<AttachmentPart> collectionOfAttachments = new ArrayList<AttachmentPart>();

        for (Iterator attachmentIterator = message.getAttachments(); attachmentIterator.hasNext()) {
            AttachmentPart attachment = (AttachmentPart) attachmentIterator.next();
            //**DO WORK HERE ON attachment**
            collectionOfAttachments.add(attachment);
        }

        message.removeAllAttachments();

        for (AttachmentPart newAttachment : collectionOfAttachments) {
            message.addAttachmentPart(newAttachment);
        }



 // This method takes an XML string as input and uses it to create a new
 // SOAPMessage object
 // and then returns that object for further use.
 private static SOAPMessage getSoapMessageFromString(String xml)
           throws SOAPException, IOException {

      MessageFactory factory = MessageFactory.newInstance();

      // Create a new message object with default MIME headers and the data
      // from the XML string we passed in
      SOAPMessage message = factory
                .createMessage(
                          new MimeHeaders(),
                          new ByteArrayInputStream(xml.getBytes(Charset
                                    .forName("UTF-8"))));
      return message;
 }