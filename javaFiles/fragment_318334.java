public static void listDir() {
    File current = new File(".");
    System.out.println(current.getAbsolutePath());
    for (String filename : current.list()) {
        System.out.println(filename);
    }
}