try {
    p=Runtime.getRuntime().exec("su");
    BufferredWriter writer = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
    writer.write("touch /data/local/tmp/file\n");
} catch(Exception e) {
    // handle exceptions
} finally {
    writer.close(); // this will automatically call writer.flush()
}