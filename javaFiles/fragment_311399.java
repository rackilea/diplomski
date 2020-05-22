/**
*  This method is responsible for extracting resource files from within the .jar to the temporary directory.
*  @param filePath The filepath relative to the 'Resources/' directory within the .jar from which to extract the file.
*  @return A file object to the extracted file
**/
public File extract(String filePath)
{
    try
    {
        File f = File.createTempFile(filePath, null);
        FileOutputStream resourceOS = new FileOutputStream(f);
        byte[] byteArray = new byte[1024];
        int i;
        InputStream classIS = getClass().getClassLoader().getResourceAsStream("Resources/"+filePath);
//While the input stream has bytes
        while ((i = classIS.read(byteArray)) > 0) 
        {
//Write the bytes to the output stream
            resourceOS.write(byteArray, 0, i);
        }
//Close streams to prevent errors
        classIS.close();
        resourceOS.close();
        return f;
    }
    catch (Exception e)
    {
        System.out.println("An error has occurred while extracting the database. This may mean the program is unable to have any database interaction, please contact the developer.\nError Description:\n"+e.getMessage());
        return null;
    }
}