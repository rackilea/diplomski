FileOutputStream fos = new FileOutputStream("hello-world.zip");
BufferedOutputStream bos = new BufferedOutputStream(fos);
ZipOutputStream zos = new ZipOutputStream(bos);

try {
    for (int i = 0; i < 10; i++) {
        // not available on BufferedOutputStream
        zos.putNextEntry(new ZipEntry("hello-world." + i + ".txt"));
        zos.write("Hello World!".getBytes());
        // not available on BufferedOutputStream
        zos.closeEntry();
    }
}
finally {
    zos.close();
}