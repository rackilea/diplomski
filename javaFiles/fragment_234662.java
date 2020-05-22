import java.io.IOException;

public class ShellCommand {
    public void execShellCmd(String cmd) throws IOException, InterruptedException {

        Process p = Runtime.getRuntime().exec(new String[] {"gnome-terminal", "-x", "bash", "-c", cmd});
        System.out.println( "Started proc" );
        p.waitFor();
        System.out.println( "Done waiting" );
    }

    public static void main( String[] args ) {
        ShellCommand s = new ShellCommand();

        try {
            s.execShellCmd( "sleep 10; echo done" );
        } catch( Exception e ) {
        }
    }
}