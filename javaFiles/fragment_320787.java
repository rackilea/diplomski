SOAPMessage smResponse2 = scTunnel.call(smRequest, urlWebService);

// strip off the newlines and CR's and tabs.
java.io.ByteArrayOutputStream baosHolder = new java.io.ByteArrayOutputStream();
smResponse2.writeTo(baosHolder);
String strSOAPMsg = baosHolder.toString().replaceAll("\n+","").replaceAll("\r+","").replaceAll("\t+","");

SOAPMessage smResponse = mfFactory.createMessage(new MimeHeaders(), new java.io.ByteArrayInputStream(strSOAPMsg.getBytes(java.nio.charset.Charset.forName("UTF-8"))));