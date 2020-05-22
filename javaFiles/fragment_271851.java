BufferedWriter out;
try {
    out = new BufferedWriter(new FileWriter("out.txt"));
    out.write("aString");
} catch (IOException e) {
    throw new RuntimeException(e);    
} finally {
    if (out != null) {
        try { out.close(); } catch (IOException e) {}
    }
}