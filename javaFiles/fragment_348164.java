Attachments attachments3 = new Attachments();
Base64 x = new Base64();
String imageDataString = x.encodeAsString(fileData);
attachments3.setContent(imageDataString);
attachments3.setType("image/png");//"application/pdf"
attachments3.setFilename("x.png");
attachments3.setDisposition("attachment");
attachments3.setContentId("Banner");
mail.addAttachments(attachments3);