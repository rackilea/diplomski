public static String getTotalRAM() {
    RandomAccessFile reader = null;
    String load = null;
    try {
        reader = new RandomAccessFile("/proc/meminfo", "r");
        load = reader.readLine();
    } catch (IOException ex) {
        ex.printStackTrace();
    } finally {
        // Streams.close(reader);
    }
    return load;
}