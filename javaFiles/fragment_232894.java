void add(Object toAdd) {
    Object obj = getObject();
    if (obj instanceof List<?>) {
        ((List<Object>)obj).add(toAdd);
        return;
    }
    throw new SomeException();
}