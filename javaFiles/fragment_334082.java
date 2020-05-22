FileInputStream fin = new FileInputStream("your.zip");
ZipInputStream zin = new ZipInputStream(fin);
ZipEntry ze = null;
while ((ze = zin.getNextEntry()) != null) {
    if (ze.getName().equals("your.xml")) {
        // pass zin to DocumentBuilder
    }
}