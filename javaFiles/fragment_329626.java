try(
    FileInputStream fin = new FileInputStream(input);
    FileOutputStream fout = new FileOutputStream(output);
    GZIPOutputStream out = new GZIPOutputStream(fout)
) {
    // ... do work
}