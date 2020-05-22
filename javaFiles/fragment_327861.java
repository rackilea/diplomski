@Override
public void done() 
{
    try 
    {
        pm.setNote(get());
    } 
    catch (Exception e)
    {
        e.printStackTrace(System.err);
        System.out.println("error");
    }
}

@Override
protected void process(List<String> chunks)
{
   pm.setNote(chunks.get(chunks.size() - 1));
}