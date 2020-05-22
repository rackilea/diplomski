ImageIcon(String filename, String description) {
    image = Toolkit.getDefaultToolkit().getImage(filename);
    if (image == null) {
        return;
   }
   this.filename = filename;
   this.description = description;
   loadImage(image);
}