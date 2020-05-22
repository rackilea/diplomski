public static void main(String[] args) throws IOException {
    File f = new File(args[0]);
    BufferedReader reader = new BufferedReader(new InputStreamReader(
            new FileInputStream(f), "UTF-8")); // Use correct encoding here.
    RandomAccessFile writer = new RandomAccessFile(f, "rw");

    String line = null;
    long totalWritten = 0;
    while ((line = reader.readLine()) != null) {
        line = line.trim() + "\n"; // Remove your prefix here.

        byte[] b = line.getBytes("UTF-8");
        writer.write(b);
        totalWritten += b.length;
    }

    reader.close();

    writer.setLength(totalWritten);
    writer.close();
}