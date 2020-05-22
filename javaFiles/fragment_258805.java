public static String stripBOM(InputStream stream)
{
    try
    {
        byte[] buffer = new byte[1024];
        ByteArrayOutputStream os = new ByteArrayOutputStream(1024);
        byte[] bom = new byte[3];
        stream.read(bom);
        int bytesRead;
        while ((bytesRead = stream.read(buffer)) != -1)
        {
            os.write(buffer, 0, bytesRead);
        }
        os.close();
        return os.toString("UTF-8");
    }
    catch (IOException e)
    {
        return "";
    }
}