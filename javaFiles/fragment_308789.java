InputStream is = ClassLoader.class.getResourceAsStream("/com/example/libMYLIB.so");
    File file = File.createTempFile("lib", ".so");
    OutputStream os = new FileOutputStream(file);
    byte[] buffer = new byte[1024];
    int length;
    while ((length = is.read(buffer)) != -1) {
        os.write(buffer, 0, length);
    }
    is.close();
    os.close();

    System.load(file.getAbsolutePath());
    file.deleteOnExit();