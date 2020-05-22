public void sendName(String str) 
{
    PrintStream ps = null;
    try 
    {
        System.out.println("Send: "+str);
        ps = new PrintStream(s.getOutputStream());
        ps.println(str);
        ps.flush();
    } catch (IOException ex) 
    {
    }
    finally
    {
       if(ps != null)
         ps.close();
    }
}