Host: localhost
   User-Agent: Mozilla/5.0 (Windows NT 6.2; WOW64; rv:21.0) Gecko/20100101 Firefox/21.0
   Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
   Accept-Language: en-US,en;q=0.5
   Accept-Encoding: gzip, deflate
   DNT: 1
   Referer: http://localhost/index.html
   Connection: keep-alive
   Content-Type: multipart/form-data; boundary=---------------------------274761981030199
   Content-Length: 1405

   -----------------------------274761981030199
   Content-Disposition: form-data; name="name1"

   pppppp
   -----------------------------274761981030199
   Content-Disposition: form-data; name="name2"

   rrrrrrrrr
   -----------------------------274761981030199
   Content-Disposition: form-data; name="name3"

   eeeeeeee
   -----------------------------274761981030199
   Content-Disposition: form-data; name="name4"

   2
   -----------------------------274761981030199
   Content-Disposition: form-data; name="name5"; filename="CgiPost.java"
   Content-Type: text/x-java-source

   import java.io.*;

   // This appears in Core Web Programming from
   // Prentice Hall Publishers, and may be freely used
   // or adapted. 1997 Marty Hall, hall@apl.jhu.edu.


   public class CgiPost extends CgiGet 
   {

   public static void main(String[] args) 
   {

   try 
   {

   DataInputStream in
    = new DataInputStream(System.in);

   String[] data = { in.readLine() };

   CgiPost app = new CgiPost("CgiPost", data, "POST");

   app.printFile();
       } catch(IOException ioe) {
         System.out.println
           ("IOException reading POST data: " + ioe);

   }
     }

     public CgiPost(String name, String[] args,
     String type) {
       super(name, args, type);
     }
   }

   -----------------------------274761981030199
   Content-Disposition: form-data; name="name6"

   pppppppppp
   -----------------------------274761981030199--