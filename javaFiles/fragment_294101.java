File file = new File("Library\\test.txt");
if (file.getParentFile().mkdir()) {
    file.createNewFile();
} else {
    throw new IOException("Failed to create directory " + file.getParent());
}