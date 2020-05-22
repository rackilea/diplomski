FormBodyPart customBodyPart = new FormBodyPart("file", body) {
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
    entity.addPart(customBodyPart);