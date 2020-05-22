attachmentUrl -> {
    try {
        Attachment attachment = new Attachment();
        File attachmentFile = new File(getFilename(attachment.getAttachmentId(), attachmentUrl));
        FileUtils.copyURLToFile(
                attachmentUrl,
                attachmentFile,
                CONNECT_TIMEOUT,
                READ_TIMEOUT);
        attachment.setAttachmentFile(attachmentFile);
        return attachment;
    } catch (IOException e) {
        e.printStackTrace();
        LOGGER.error(e.getLocalizedMessage());
    }
    return null;
}