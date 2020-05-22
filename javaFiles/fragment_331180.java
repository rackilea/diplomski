File file = fc.getSelectedFile();
try {
    img = ImageIO.read(file);
} catch (IOException e) {
    throw new RuntimeException("Could not load \"" + file + "\"", e);
}