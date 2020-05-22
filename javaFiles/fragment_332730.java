import java.io.*;

public class Temp
{

    public static void main(String[] args) throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("Hello World!");
        String temp = br.readLine();
        System.out.println("Your line : \"" + temp + "\"");
    }
}