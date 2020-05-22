import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Foo {
    public static void main(String args[])
        throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        String line;
        while ((line = r.readLine()) != null) {
            sum += Integer.parseInt(line);
        }
        System.out.println(sum);
    }
}