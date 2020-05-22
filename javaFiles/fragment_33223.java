public static void main(String[] args) 
{
    try
    {
        File file = new File("C:\\Users\\Parsa\\Desktop\\save.ser");
        FileOutputStream output = new FileOutputStream(file);
        ObjectOutputStream objectOutput = new ObjectOutputStream(output);
        Save save = new Save(10,"aaa",true);
        objectOutput.writeObject(save);
        objectOutput.flush();
        objectOutput.close();
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
}