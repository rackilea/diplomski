private File copyResourceIntoTempFile(String resource, File target) throws IOException {
    InputStream input = getClass().getResourceAsStream(resource);

    OutputStream out = new FileOutputStream(target);
    int read;
    byte[] bytes = new byte[1024];

    while ((read = input.read(bytes)) != -1) {
        out.write(bytes, 0, read);
    }
    //target.deleteOnExit();


    if (!target.exists()) {
        throw new FileNotFoundException("Error: File " + target + " not found!");
    }

    return target;
}