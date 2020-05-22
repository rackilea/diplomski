public static void loadWithoutThreads(File[] array) {
    for (File file : array) {
        try {
            ImageIO.read(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}