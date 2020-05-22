try {
    ZipFile zip = new ZipFile("someZipFile.zip");
    ZipEntry entry = zip.getEntry(fileName);
    if (entry != null) {
        InputStream in = zip.getInputStream(entry);
        // see Note #3.
        File tempFile = File.createTempFile("_AUDIO_", ".wav");
        FileOutputStream out = new FileOutputStream(tempFile);
        IOUtils.copy(in, out);
        // do something with tempFile (like play it)
    } else {
        // no such entry in the zip
    }
} catch (IOException e) {
    // handle your exception cases...
    e.printStackTrace();
}