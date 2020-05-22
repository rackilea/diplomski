...
Blob blob = blobStore.getBlob(containerName, fileName);
InputStream is = blob.getPayload.openStream();
String contentType = "image/jpeg"; //or whatever content the blob is.
AttachmentInputStream ais = new AttachmentInputStream("attachment_id", is, contentType);
db.createAttachment("new_document_id", ais);
...