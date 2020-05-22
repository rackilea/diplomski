private static void store(String name, byte[] finishedClass) {
    Path path = Paths.get(name + ".class");
    try {
        FileChannel fc = null;
        try {
            Files.deleteIfExists(path);
            fc = new FileOutputStream(path.toFile()).getChannel();
            fc.write(ByteBuffer.wrap(finishedClass));
        } finally {
            if (fc != null) {
                fc.close();
            }
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}