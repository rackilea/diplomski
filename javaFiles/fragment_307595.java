private void SaveState(String fileName, MemoryApiState mas)
{

  try     
    {
    FileOutputStream fileOut = new FileOutputStream(fileName + ".sta");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(mas);
        out.close();
        fileOut.close();
    }
        catch (IOException i)
         {
           i.printStackTrace();
         }
}