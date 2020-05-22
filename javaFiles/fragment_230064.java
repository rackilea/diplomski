import java.io.*;

public class Test
{
    public static void main(String[] args)
        throws Exception // Just for simplicity
    {
        System.setProperty("line.separator", "xxx");
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("foo");
        pw.println("bar");
        pw.flush();
    }
}