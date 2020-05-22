private MemoryApiState LoadState(String fileName)
 {
    try
        {


          FileInputStream fileIn = new FileInputStream(fileName + ".sta");
          ObjectInputStream in = new ObjectInputStream(fileIn);
          MemoryApiState mas = (MemoryApiState)in.readObject();
          in.close();
          fileIn.close();

         return mas;
        }
    catch (IOException i)
        {
          return null;
        }
    catch (ClassNotFoundException c)
        {         
          c.printStackTrace();
        }
            return null;
 }