public static void saveObject(HashMap<String, HashMap<Integer, ArrayList<Integer>>> obj, String filePath)
{
    OutputStream os = null;
    try
    {
        os = new ObjectOutputStream(new FileOutputStream(filePath));
        os.writeObject(obj);
    }
    catch(Exception ex){}
    finally
    {
        os.close();
    }
}