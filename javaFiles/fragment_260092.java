public Source convertToSource(Object object) {
    Source source = null;
    if (object instanceof Source) {
        source = (Source) object;
    }
    else if (object instanceof Document) {
        source = new DOMSource((Document) object);
    }
    else if (object instanceof String) {
        source = new StringSource((String) object);
    }
    else {
        throw new MessagingException("unsupported payload type [" + object.getClass().getName() + "]");
    }
    return source;
}