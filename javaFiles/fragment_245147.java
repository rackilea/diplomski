public static HashMap<String, HashMap<Integer, ArrayList<Integer>>> loadObject(String filePath)
{
    HashMap<String, HashMap<Integer, ArrayList<Integer>>> obj = null;
    InputStream is = null;
    try
    {
        is = new ObjectInputStream(new FileInputStream(filePath));
        obj = (HashMap<String, HashMap<Integer, ArrayList<Integer>>>) is.readObject();
    }
    catch(Exception ex){}
    finally
    {
        is.close();
    }
    return obj;
}