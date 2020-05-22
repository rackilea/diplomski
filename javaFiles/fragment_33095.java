MessageHeader sendMH = new MessageHeader(MessageHeader.MessageHeaderType.BindingRequest);
sendMH.generateTransactionID();

// add an empty ChangeRequest attribute. Not required by the standard, but JSTUN server requires it
ChangeRequest changeRequest = new ChangeRequest();
sendMH.addMessageAttribute(changeRequest);

byte[] data = sendMH.getBytes();

// not shown - sending the message