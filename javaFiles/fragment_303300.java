public static void writeOut(Object p, File selection)
        throws FileNotFoundException, IOException {
    try (ObjectOutputStream oos = new ObjectOutputStream(
            new FileOutputStream(selection))) {
        oos.writeObject(p);
    }
}