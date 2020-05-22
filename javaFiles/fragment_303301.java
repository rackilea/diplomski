public static Object readIn(File selection) throws FileNotFoundException,
        IOException, ClassNotFoundException {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
            selection))) {
        return ois.readObject();
    }
}