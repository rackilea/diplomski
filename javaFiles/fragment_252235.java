class ComplexThing implements Serializable {
    private Object writeReplace() throws ObjectStreamException {
        return new SimpleHiddenReplacement();
    }
}
private class SimpleHiddenReplacement implements Serializable {
    private Object readResolve() throws ObjectStreamException {
        return new ComplexThing();
    }
}