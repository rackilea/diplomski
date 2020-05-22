Folder folder = _message.getFolder();
// Open folder in read-only mode
if (folder.isOpen()) {
    if ((folder.getMode() & Folder.READ_WRITE) != 0) {
        folder.close(false);
        folder.open(Folder.READ_ONLY);
    }
} else {
    folder.open(Folder.READ_ONLY);
}

Object content = _message.getContent();
String body = null;
if (content instanceof String) {
    body = (String) content;
} else if (content instanceof Multipart) {
    Multipart multipart = (Multipart) content;
    BodyPart part = multipart.getBodyPart(0);
    body = (String) part.getContent();
}
if (folder.isOpen()) {
    folder.close(false);
}