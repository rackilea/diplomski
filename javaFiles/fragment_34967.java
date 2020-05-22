ByteArrayOutputStream out = QRCode.from("Hello World").to(ImageType.PNG).stream();

try {
    FileOutputStream fout = new FileOutputStream(new File("C:\\QR_Code.JPG"));

    fout.write(out.toByteArray());

    fout.flush();
    fout.close();

} catch (FileNotFoundException e) {
    // Do Logging
} catch (IOException e) {
    // Do Logging
}