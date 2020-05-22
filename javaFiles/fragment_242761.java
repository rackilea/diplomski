byte[] bytes = new byte[10000];
// ...
FileOutputStream out = new FileOutputStream(...);
try {
    out.write(bytes);
} finally {
    out.close();
}