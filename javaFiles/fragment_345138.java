void writeObject (ObjectOutputStream out) throws IOException{
    out.writeObject(familyName);
    out.writeObject(name);
}
void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    familyName = (String) in.readObject();
    name = (String) in.readObject();
}

void writeObject (ObjectOutputStream out) throws IOException{
    out.writeObject(name);
}
void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    name = (String) in.readObject();
}