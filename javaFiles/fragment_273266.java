String cwd = System.getProperty("user.dir");
File dirAboveCws = new File(cwd).getParentFile();
File[] imageFiles = dirAboveCws.listFiles(new FileFilter() {
    @Override
    public boolean accept(File pathname) {
        return !pathname.getName().contains("jpg");
    }
});

for (File imageFile : imageFiles) {
    FileInputStream fileInputStream = new FileInputStream(imageFile);
    Image image = ImageIO.read(fileInputStream);  // Here is your image
}