import java.io.PrintStream;
import java.io.PrintWriter;

public class TimeChecker 
{
    public static void main(String[] args) 
    {
        /**
         * Normal System.out.println
         */
        long start = System.currentTimeMillis();
        for(int i=1; i<1000000000; i++);
        long end = System.currentTimeMillis();
        System.out.println((end-start));

        /**
         * Using PrintWriter
         * 
         * Note: The output is displayed only when you write "out.close()"
         * Till then it's in buffer. So once you write close() 
         * then output is printed
         */
        PrintWriter out = new PrintWriter(System.out);
        start = System.currentTimeMillis();
        for(int i=1; i<1000000000; i++);
        end = System.currentTimeMillis();
        out.println((end-start));

        /**
         * Using PrintStream
         */
        PrintStream ps = new PrintStream(System.out, true);
        System.setOut(ps);
        start = System.currentTimeMillis();
        for(int i=1; i<1000000000; i++);
        end = System.currentTimeMillis();
        ps.println((end-start));

        // You need to close this for PrintWriter to display result
        out.close();
    }

}