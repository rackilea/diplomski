List<File> imageFiles = new ArrayList<>(Arrays.asList(new File(rootFolder.getText()).listFiles(new FileFilter() {
    @Override
    public boolean accept(File pathname) {
        return pathname.getName().toLowerCase().endsWith(".jpg")
                || pathname.getName().toLowerCase().endsWith(".png")
                || pathname.getName().toLowerCase().endsWith(".bmp")
                || pathname.getName().toLowerCase().endsWith(".gif");
    }
})));
imageFiles.removeAll(haveUsed);
Collections.shuffle(imageFiles);

File imageFile = imageFiles.remove(0);
haveUsed(imageFile);

jLabel.setIcon(new ImageIcon(ImageIO.read(imageFile)));