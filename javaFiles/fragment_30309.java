import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class TestServer
{
    public static void main(String[] args)
    {
        try
        {
        ServerSocket ss=new ServerSocket(5010);
        Socket s=ss.accept();
        BufferedReader get= new BufferedReader(new InputStreamReader(s.getInputStream()));

        FileWriter writedata=new FileWriter("c://Test//testoutput.txt");

        BufferedWriter bw=new BufferedWriter(writedata);

        String line=bw.toString();
        while ((line = get.readLine()) != null) {

            bw.write(line + "\n");

        }
        bw.flush();
        bw.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}


import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TestClient
{
    public static void main(String[] args)
    {
        try
        {

           Socket ss=new Socket("localhost",5010);

           BufferedOutputStream put=new BufferedOutputStream(ss.getOutputStream());
           BufferedReader st=new BufferedReader(new InputStreamReader(ss.getInputStream()));

           File f=new File("c://Test//testinput.txt");
           FileInputStream fis=new FileInputStream(f);
           byte buf[]=new byte[1024];
           int read;
           while((read=fis.read(buf,0,1024))!=-1)
           {
               put.write(buf,0,read);
               put.flush();
           }
           //d.close();
           System.out.println("File transfered");
           ss.close();
           ss.close();


        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}