private void writeObject(ObjectOutputStream oos) throws IOException {

    oos.defaultWriteObject();
    oos.writeInt(z);
    System.out.println("session serialized");
}

private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {

    ois.defaultReadObject();
    z = ois.readInt();
}