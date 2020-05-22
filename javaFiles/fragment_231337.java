public synchronized void addBodyPart(BodyPart part) throws MessagingException {
    if (parts == null) {
        parts = new Vector();
        parts.addElement(part);
        part.setParent(this);
    }
}