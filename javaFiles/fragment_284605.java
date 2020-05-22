FTPClient client = new FTPClient();
FileInputStream fis = null;

try 
{
    client.connect(serverip);
    client.login("user, pass);
    client.setFileType(FTPClient.BINARY_FILE_TYPE);

    // change directory to serverip/file/
    if (client.changeWorkingDirectory("/file"))
    {       
        // Create an InputStream of the file to be uploaded
        String filename = Shared.saveLocation + Shared.saveAs;
        fis = new FileInputStream(filename);

        // Store file to server
        client.storeFile(Shared.saveAs, fis);
    }
    client.logout();
} 
catch (IOException e) 
{
    e.printStackTrace();
} 
finally 
{
    try
    {
        if (fis != null) 
        {
            fis.close();
        }
        client.disconnect();
    } 
    catch (IOException e) 
    {
        e.printStackTrace();
    }
}