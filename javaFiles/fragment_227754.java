string fileName = "D:\\newZIPfile.zip";

using (FileStream fs = new FileStream(fileName, FileMode.Create))
{
    byte[] buffer = new byte[32768];
    int read;
    while ((read = Request.InputStream.Read(buffer, 0, buffer.Length)) > 0)
    {
        fs.Write (buffer, 0, read);
    }
}