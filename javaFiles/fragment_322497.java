private void writeObject(ObjectOutputStream stream) throws IOException {
    stream.defaultWriteObject();
    stream.writeInt(c.size);
}

private void readObject(ObjectInputStream stream) throws IOException,
        ClassNotFoundException {
    stream.defaultReadObject();
    c = new Collar();
    c.size = stream.readInt();
}