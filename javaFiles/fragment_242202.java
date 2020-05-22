Cipher enc = Cipher.getInstance("...");
enc.init(...);
try (OutputStream fos = Files.newOutputStream(path);
     OutputStream os = new CipherOutputStream(fos, enc)) {
   writingObject.write(os);
}