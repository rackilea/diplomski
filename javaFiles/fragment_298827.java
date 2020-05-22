FileInputStream in = new FileInputStream(mainfest);
byte[] bytes = new byte[1024];
int count;

FileOutputStream fout = new FileOutputStream("test.zip");
ZipOutputStream zout = new ZipOutputStream(fout);

ZipEntry ze = new ZipEntry(mainfest); // this is the name as it will appear if you opened the zip file with WinZip or some other zip manager
zout.putNextEntry(ze);

while ((count = in.read(bytes)) > 0) {
    zout.write(bytes, 0, count);
}

zout.closeEntry();
zout.close();