try {
    FileInputStream fileIn = new FileInputStream("filename.sav");
    try (ObjectInputStream objIn = new ObjectInputStream(fileIn)) {
        int number = (int) objIn.readObject();
        int[] array = (int[]) objIn.readObject();
    }
} catch (IOException | ClassNotFoundException e) {
}