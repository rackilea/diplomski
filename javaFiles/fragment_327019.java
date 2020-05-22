try (ByteArrayOutputStream baos = new ByteArrayOutputStream()){
    final URL url = new URL("http://www.gravatar.com/avatar/" + account.getGravatarHash() + "?d=identicon");
    InputStream inputStream = url.openStream();
    byte[] buffer = new byte[1024];
    int n;
    while (-1 != (n = inputStream.read(buffer))) {
        baos.write(buffer, 0, n);
    }
    inputStream.close();
    pic = baos.toByteArray();
} catch (IOException e) {
    e.printStackTrace();
}