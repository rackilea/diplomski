Vector attachmentNames = session.evaluate("@AttachmentNames", doc);
Enumeration e = attachmentNames.elements();
    while (e.hasMoreElements()) {
        String attachmentName = e.nextElement();
        EmbeddedObject eo = doc.getAttachment( attachmentName );
        if (eo.getType() == EmbeddedObject.EMBED_ATTACHMENT) {
            eo.extractFile("c:\\extracts\\" + eo.getSource());
        }
    }