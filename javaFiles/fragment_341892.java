public class SystemOutProgressMonitor implements SftpProgressMonitor
{
    public SystemOutProgressMonitor() {;}

    public void init(int op, java.lang.String src, java.lang.String dest, long max) 
    {
        System.out.println("STARTING: " + op + " " + src + " -> " + dest + " total: " + max);
    }

    public boolean count(long bytes)
    {
        for(int x=0; x < bytes; x++) {
            System.out.print("#");
        }
        return(true);
    }

    public void end()
    {
        System.out.println("\nFINISHED!");
    }
}