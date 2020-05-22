public static boolean lastLineisCRLF(String filename) {
    RandomAccessFile raf = null;
    try {
        raf = new RandomAccessFile(filename, "r");
        long pos = raf.length() - 2;
        if (pos < 0) return false; // too short
        raf.seek(pos);
        return raf.read() == '\r' && raf.read() == '\n';
    } catch (IOException e) {
        return false;
    } finally {
        if (raf != null) try {
            raf.close();
        } catch (IOException ignored) {
        }
    }
}