String filename = ""; //Filename or filepath to your .properties file
Properties properties = new Properties();
try {
    InputStream inputStream = new FileInputStream(filename);
    properties.load(inputStream);
    inputStream.close();
} catch (java.io.IOException e) {
    e.printStackTrace();
}