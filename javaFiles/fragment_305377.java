public void createSerialisable() throws IOException
{
    FileOutputStream fileOut =  new FileOutputStream("theBkup.ser");
    ObjectOutputStream out =  new ObjectOutputStream(fileOut);
    out.writeObject(allDeps);
    **out.flush();** // Probably not strictly necessary, but a good idea nonetheless
    **out.close();** // Probably not strictly necessary, but a good idea nonetheless
    options();
}

public void readInSerialisable() throws IOException
{
    FileInputStream fileIn = new FileInputStream("theBKup.ser");

    ObjectInputStream in = new ObjectInputStream(fileIn);

    try
    { 
        **// You only wrote one object, so only try to read one object back.**
        allDeps = (ArrayList) in.readObject();
    }
    catch (IOException exc)
    {
        System.out.println("didnt work");
        **exc.printStackTrace();** // Very useful for findout out exactly what went wrong.
    }
}