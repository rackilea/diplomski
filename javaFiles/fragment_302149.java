OutputStream os = new FileOutputStream("out1.jpg");
try {
    os.write(getPhoto());
} finally {
    os.close();
}