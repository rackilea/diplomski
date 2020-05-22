MimeMultipart alternativeMultipart = new MimeMultipart("alternative");

BodyPart textPart = new MimeBodyPart();
textPart.setContent("someText", "text/plain");
alternativeMultipart.addBodyPart(textPart);

BodyPart htmlPart = new MimeBodyPart();
htmlPart.setContent("someHtml", "text/html");
alternativeMultipart.addBodyPart(htmlPart);

MimeBodyPart alternativeBodyPart = new MimeBodyPart();
alternativeBodyPart.setContent(alternativeMultipart);

MimeMultipart mixedMultipart = new MimeMultipart("mixed");
mixedMultipart.addBodyPart(alternativeBodyPart);

MimeBodyPart textPart1 = new MimeBodyPart();
textPart1.setContent("someOtherText", "text/plain");
mixedMultipart.addBodyPart(textPart1);