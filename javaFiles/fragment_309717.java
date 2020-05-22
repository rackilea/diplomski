private void CopyRAWtoPhone(int id, String path) throws IOException {
InputStream in = getResources().openRawResource(id);
FileOutputStream out = new FileOutputStream(path);
byte[] buff = new byte[1024];
int read = 0;
try { 
    while ((read = in.read(buff)) > 0) {
        out.write(buff, 0, read);
    } 
} finally { 
    in.close();
    out.close();
 } 
}