int i = 0; 
for (Attachment attachment : attachmentDetails) {
    Upload upload = new Upload();
    upload.setUuid(attachment.getUuid());
    upload.setCustomerId(myList.get(i).getCustomerId());
    upload.setFileName(myList.get(i).getFileName());
    upload.setFileSize(myList.get(i).getFileSize());
    upload.setContent(myList.get(i).getContent());

    uploadList.add(upload);
    i++;
}