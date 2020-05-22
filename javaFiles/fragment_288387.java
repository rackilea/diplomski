InputStream ins = blob.getBinaryStream();
File targetFile = new File("./" + fileName);
OutputStream outStream = new FileOutputStream(targetFile);

byte[] buffer = new byte[8000];
int count = 0;
while ((count = ins.read(buffer)) != -1) {
    outStream.write(buffer);
}

// then close your output
outStream.close ();