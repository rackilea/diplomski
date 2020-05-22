public void add_note(String note) throws FileNotFoundException, IOException, InvalidFormatException
{
    try
    {
          ...content...
    }
    catch(FileNotFoundException fnfEx)
    {
       throw new FileNotFoundException("File was not found");
    }
    catch(IOException ioEx)
    {
       throw new FileNotFoundException("I/O exception");
    }
    catch(InvalidFormatException invEx)
    {
       throw new FileNotFoundException("Invalid format errror");
    }
}