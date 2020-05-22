List<String> classNames = new ArrayList<String>();
ZipInputStream zip = new ZipInputStream(new FileInputStream("/path/to/jar/file.jar"));
int numberOfLevels=0;
for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
    if (!entry.isDirectory() && entry.getName().endsWith(".tmx")) {
        numberOfLevels++;
    }
}