public MyClass() {
    URL url = getClass().getResource("filename.txt");
    File file = new File(url.getPath());
    InputStream input = new FileInputStream(file);
    // ...
}