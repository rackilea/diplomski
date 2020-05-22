private static void saveItemToFile(File folder, Item item) throws IOException {
    File file = new File(folder, item.getName() + ".obj");
    try (ObjectOutputStream oos =
            new ObjectOutputStream(new FileOutputStream(file))) {
        oos.writeObject(item);
    }
}