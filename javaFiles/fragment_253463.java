class Person implements Serializable{

 // YOUR CODE GOES HERE...........

 public Person makeClone() throws IOException, ClassNotFoundException {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    ObjectOutputStream out = new ObjectOutputStream(outputStream);
    out.writeObject(this);

    ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
    ObjectInputStream in = new ObjectInputStream(inputStream);
    Person copied = (Person) in.readObject();
    return copied;
}