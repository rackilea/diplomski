String[] sourceFiles = { "C:/file1", "C:/file2" };

ByteArrayOutputStream baos = new ByteArrayOutputStream();
ZipOutputStream zout = new ZipOutputStream(baos);

byte[] buffer = new byte[4096];

for (int i = 0; i < sourceFiles.length; i++)
{
    FileInputStream fin = new FileInputStream(sourceFiles[i]);
    zout.putNextEntry(new ZipEntry(sourceFiles[i]));

    int length;
    while ((length = fin.read(buffer)) > 0)
    {
        zout.write(buffer, 0, length);
    }

    zout.closeEntry();
    fin.close();
}

zout.close();

byte[] bytes = baos.toByteArray();