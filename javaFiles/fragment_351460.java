public static void main(String[] args) throws IOException, ClassNotFoundException {
    ObjectInputStream input = new ObjectInputStream(new FileInputStream(new File("yourFile.bin"))); //or any file type
    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(new File("yourFile.bin")));

    output.writeObject(yourObject);
    YourObject yourObject = input.readObject();
}