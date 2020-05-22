Properties py = new Properties();
long lastModMillis = 0L;
long modMillis = file.lastModified() // to get the file modification time

if (modMillis != lastModMillis)
{
    // reload data
    FileInputStream fis = ... 
    py.clear();
    py.load(fis);
    lastModMillis = modMillis;
}