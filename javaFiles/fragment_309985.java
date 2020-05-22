try (InputStream is = new FileInputStream("guitar_sim.mp3");
     OutputStream os = new FileOutputStream("test_song1.mp3")) {
  byte[] data = new byte[2048];
  int size;
  while ((size = is.read(data)) != -1) {
    os.write(data, 0, size);
  }
} catch (IOException e) {
  e.printStackTrace();
}