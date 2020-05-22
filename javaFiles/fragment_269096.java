public static String exportInnerJar(){
    String jarDir = ""; 
    try {
        //Get the parent directory of the outer jar.
        jarDir = URLDecoder.decode(ClassLoader.getSystemClassLoader().getResource(".").getPath(),"UTF-8");
    } catch (UnsupportedEncodingException e) {
        System.err.println("Fail to find the outer jar location");
        e.printStackTrace();
    }
    //The location of the inner jar
    //The example means the innar jar is at outer.jar/example/inner.jar where "example" is a folder under the root of the outer jar.
    InputStream is = ClassName.class.getResourceAsStream("/example/inner.jar");

    //The location to be exported to, you can change this to wherever you want
    File exportInnerJar = new File(jarDir).toPath().resolve("inner.jar").toFile();

    //Create the file
    exportInnerJar.createNewFile();

    //Use FileOutputStream to write to file
    FileOutputStream fos = new FileOutputStream(exportInnerJar);

    //setup a buffer
    int readBytes;
    byte[] buffer = new byte[4096];

    //export
    while ((readBytes = is.read(buffer)) > 0) {
        fos.write(buffer, 0, readBytes);
    }

    // close streams
    is.close();
    fos.close();

    return exportInnerJar.getAbsolutePath();
}