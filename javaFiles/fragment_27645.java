Path sourcePath = Paths.get("C:/D/test.html");
    try (ZipOutputStream zipOut = new ZipOutputStream(
            new FileOutputStream("C:/D/test/test.zip"))) {

        zipOut.putNextEntry(new ZipEntry("file1.txt"));
        Files.copy(sourcePath, zipOut);
        zipOut.closeEntry();

        zipOut.putNextEntry(new ZipEntry("file2.txt"));
        Files.copy(sourcePath, zipOut);
        zipOut.closeEntry();

        zipOut.putNextEntry(new ZipEntry("inner.zip"));
        ZipOutputStream innerZipOut = new ZipOutputStream(zipOut);
        {
            innerZipOut.putNextEntry(new ZipEntry("file3.txt"));
            Files.copy(sourcePath, innerZipOut);
            innerZipOut.closeEntry();

            innerZipOut.putNextEntry(new ZipEntry("file4.txt"));
            Files.copy(sourcePath, innerZipOut);
            innerZipOut.closeEntry();

            innerZipOut.finish(); // Instead of close().
        }
        zipOut.closeEntry();

    } catch (IOException e) {
        e.printStackTrace();
    } // Invoke close().