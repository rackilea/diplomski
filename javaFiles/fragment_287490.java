import java.io.*;
import java.net.*;
import java.util.*;
public class ft2client
{ 
    public static void main(String srgs[])throws IOException
    {
        Socket s=null;
        BufferedInputStream get=null;
        PrintWriter put=null;
        try
        { 
            s=new Socket("127.0.0.1",8085);
            get=new BufferedInputStream(s.getInputStream());
            put=new PrintWriter(s.getOutputStream(),true);

            String f;
            int u;
            System.out.println("Enter the file name to transfer from server:");
            DataInputStream dis=new DataInputStream(System.in);
            f=dis.readLine();
            put.println(f);
            File f1=new File(f);
            String str = "/home/milind/";
            FileOutputStream  fs=new FileOutputStream(new File(str,f1.toString()));
            byte jj[]=new byte[1024];
            while((u=get.read(jj,0,1024))!=-1)
            { 
                fs.write(jj,0,u);
            } 
            fs.close();
            System.out.println("File received");
            s.close();
        }catch(Exception e)
        {
            e.printStackTrace();
            System.exit(0);
        }
    }      
}