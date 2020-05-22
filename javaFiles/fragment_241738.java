Writer writer = null;

try {
    writer = new BufferedWriter(new FileWriter("test.txt"));
    writer.write("aString");
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (writer != null) try { writer.close(); } catch (IOException ignore) {}
}