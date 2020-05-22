InputStream is = new FileInputStream("a.jar");

jos.putNextEntry(new JarEntry("a.jar"));
byte[] buffer = new byte[4096];
int bytesRead;
while ((bytesRead = is.read(buffer)) != -1) {
    jos.write(buffer, 0, bytesRead);
}