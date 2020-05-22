@Override
public void run() 
{
    try 
    {
        // Driver initialization
        Win32Driver driver=new Win32Driver();
        driver.initialize();

        this.listPort();
    }
    catch (Exception e){ System.out.println("start "+e.toString()); }       
}