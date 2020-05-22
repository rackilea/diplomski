StringBody stuff = new StringBody("stuff");
FormBodyPart customBodyPart = new FormBodyPart("file", stuff) {

    @Override
    protected void generateContentDisp(final ContentBody body) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("form-data; name=\"");
        buffer.append(getName());
        buffer.append("\"");
        buffer.append("; filename=\"-\"");
        addField(MIME.CONTENT_DISPOSITION, buffer.toString());
    }

};
MultipartEntity entity = new MultipartEntity();
entity.addPart(customBodyPart);