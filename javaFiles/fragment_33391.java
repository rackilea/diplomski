public void unzipFile(String zipFile) throws ZipException, IOException 
{
int BUFFER = 2048;
ZipFile zip = new ZipFile(new File(zipFile));
String pathToMainFile = zipFile.substring(0, zipFile.length() - 4);
new File(pathToMainFile).mkdir();
Enumeration zipEntries = zip.entries();
while (zipEntries.hasMoreElements())
{
    ZipEntry entry = (ZipEntry) zipFileEntries.nextElement();
    String current = entry.getName();
    File dest = new File(pathToMainFile, current);
    File outerParentSt = dest.getParentFile();
    outerParentSt.mkdirs();

    if (!entry.isDirectory())
    {
        BufferedInputStream is = new BufferedInputStream(zip.getInputStream(entry));
        int currentByte;
        byte data[] = new byte[BUFFER];
        // write the file
        FileOutputStream fos = new FileOutputStream(dest);
        BufferedOutputStream destbuff = new BufferedOutputStream(fos,
        BUFFER);

        // r w to EOF
        while ((currentByte = is.read(data, 0, BUFFER)) != -1) {
            destbuff.write(data, 0, currentByte);
        }
        dest.flush();
        dest.close();
        is.close();
        fos.close;
    }

    if (current.endsWith(".zip")) //or jar or war
    {
        unzipFile(dest.getAbsolutePath()); //recursively
    }
  }
}