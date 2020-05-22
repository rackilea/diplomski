for (Attachment attachment : attachmentDetails) {
    Upload upload = new Upload();
    upload.setUuid(attachment.getUuid());
    for (Tiedosto tiedosto : myList) {
        if(tiedosto.getCustomerId() == attachment.getId()//assuming you have this field
            upload.setCustomerId(tiedosto.getCustomerId());
            upload.setFileName(tiedosto.getFileName());
            upload.setFileSize(tiedosto.getFileSize());
            upload.setContent(tiedosto.getContent());
    }
    uploadList.add(upload);
}