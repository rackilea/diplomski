File file = new File("some_temp_path"); # you can also use app's internal cache to store the file
FileOutputStream fos = new FileOutputStream(file);

InputStream is = context.getContentResolver().openInputStream(uri);
byte[] buffer = new byte[1024];
int len = 0;
try {
    len = is.read(buffer);
    while (len != -1) {
        fos.write(buffer, 0, len);
        len = is.read(buffer);
    }

    fos.close();
} catch (IOException e) {
    e.printStackTrace();
}