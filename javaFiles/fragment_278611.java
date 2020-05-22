Process process = Runtime.getRuntime().exec("su");
try (OutputStream out = process.getOutputStream();
     InputStream in = process.getInputStream()) {
    OutputStreamWriter outputStream = new OutputStreamWriter(out);
    outputStream.write("/system/bin/screencap -p\n");
    outputStream.flush();
    outputStream.write("exit\n");
    Bitmap screen = BitmapFactory.decodeStream(in);
}