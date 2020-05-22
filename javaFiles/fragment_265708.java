AttachmentInputStream attachment = 
  new AttachmentInputStream(attachmentId, 
                            fileInputStream, 
                            contentType, 
                            file.length());
String rev = db.createAttachment(doc.getId(), doc.getRevision(), attachment));