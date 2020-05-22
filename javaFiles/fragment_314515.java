FileOutputStream os = new FileOutputStream("out.zip");
ZipOutputStream zos = new ZipOutputStream(os);
try
{
    for (int i = 1; i <= 5; i++)
    {
        ZipEntry curEntry = new ZipEntry("file" + i + ".txt");
        zos.putNextEntry(curEntry);
        zos.write(("Good morning " + i).getBytes("UTF-8"));
    }
}
finally
{
    zos.close();
}