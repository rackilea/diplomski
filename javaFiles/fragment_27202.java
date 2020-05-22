public byte[] mimeParser(InputStream isMtm) {
    ByteArrayOutputStream baos = null;
    try {
        MimeMultipart mp = new MimeMultipart(new ByteArrayDataSource(isMtm,
                ct));
        int count = mp.getCount();
        baos = new ByteArrayOutputStream();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mp.getBodyPart(i);
            if (!Part.ATTACHMENT
                    .equalsIgnoreCase(bodyPart.getDisposition())
                    && !StringUtils.isNotBlank(bodyPart.getFileName())) {
                continue; // dealing with attachments only
            }
            bodyPart.writeTo(baos);
        }

        byte[] attachment = baos.toByteArray();
        FileUtils.writeByteArrayToFile(new File("E:/wss/attachment.zip"), attachment);
        return attachment;
    } catch (Exception ex) {
        ex.printStackTrace();
    } finally {
        if (baos != null) {
            try {
                baos.close();
            } catch (Exception ex) {

            }
        }
    }
    return null;
}