import java.io.*;
import java.net.*;
import java.util.*;
     public class ft2server
         { 

             public static void main(String args[])throws IOException
             { 
                 ServerSocket ss=null;
                 try
                 {  
                     ss=new ServerSocket(8085);
                 }
                 catch(IOException e)
                 { 
                     System.out.println("couldn't listen");
                     System.exit(0);
                 }
                 Socket cs=null;
                 try
                 { 
                     cs=ss.accept();
                     System.out.println("Connection established"+cs);
                 }
                 catch(Exception e)
                 { 
                     System.out.println("Accept failed");
                     System.exit(1);
                 } 
                 BufferedOutputStream put=new BufferedOutputStream(cs.getOutputStream());
                 BufferedReader st=new BufferedReader(new InputStreamReader(cs.getInputStream()));
                 String s=st.readLine();
                 String str = "/home/milind/Desktop/";
                 String path = str + s; 
                 System.out.println("The requested file is path: "+path);
                 System.out.println("The requested file is : "+s);
                 File f=new File(path);
                 if(f.isFile())
                 { 
                     FileInputStream fis=new FileInputStream(f);


                     byte []buf=new byte[1024];
                     int read;
                     while((read=fis.read(buf,0,1024))!=-1)
                     {
                         put.write(buf,0,read);
                         put.flush();
                     }
                     //d.close();
                     System.out.println("File transfered");
                     cs.close();
                     ss.close();
                 }  
             }  
         }