public static <T> T getObject(String filename) throws IOException, ClassNotFoundException {
    FileInputStream fis = new FileInputStream(filename);
    ObjectInputStream in = new ObjectInputStream(fis);
    T newObject = (T) in.readObject();
    in.close();
    return newObject;
}