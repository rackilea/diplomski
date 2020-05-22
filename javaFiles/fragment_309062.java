ZipEntry ze = new ZipEntry("PrettyPicture1.jpg");
zos.putNextEntry(ze);
byte[] bytes = new byte[1024];
int count = imageInputStream.read(bytes);
while (count > -1)
{
    zos.write(bytes, 0, count);
    count = imageInputStream.read(bytes);
}
imageInputStream.close();
zos.closeEntry();