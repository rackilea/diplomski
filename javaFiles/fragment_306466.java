File file = File.createTempFile("deleteme", "dat"); // put your file here.
FileOutputStream fos = new FileOutputStream(file);
long start = System.nanoTime();
byte[] bytes = new byte[32 * 1024];
for (long l = 0; l < 500 * 1000 * 1000; l += bytes.length)
    fos.write(bytes);
long mid = System.nanoTime();
System.out.printf("Took %.3f seconds to write %,d bytes%n", (mid - start) / 1e9, file.length());
fos.close();
long end = System.nanoTime();
System.out.printf("Took %.3f seconds to close%n", (end - mid) / 1e9);