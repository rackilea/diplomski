OutputStream out = response.getOutputStream();
FileInputStream in = new FileInputStream(fileToDownload);
byte[] buffer = new byte[4096];
int length;
while ((length = in.read(buffer)) > 0){
    out.write(buffer, 0, length);
}
in.close();
out.flush();