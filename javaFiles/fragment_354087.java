String dir = AdfmfJavaUtilities.getDirectoryPathRoot(AdfmfJavaUtilities.ApplicationDirectory);
String filePath= dir + "/myfile.txt";
try
    {
        File file = new File(filePath);
        if (file.createNewFile())
        {
            //throw new AdfException("crée", AdfException.INFO);
        }
        else
        {
            throw new AdfException("non crée", AdfException.INFO);
        }
    } 
    catch (IOException e) 
    {
        throw new AdfException(e.getMessage(), AdfException.INFO);
    }