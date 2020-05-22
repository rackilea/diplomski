import java.net.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import javax.swing.*;
import java.awt.*;
import jserv.*;

public class JavaServer
{
    public static void main(String[] args) 
        throws Exception
    {
        ServerSocket server = null;
        Socket conn = null;
        BufferedReader in = null;
        PrintWriter out = null;
        String msg = null;
        ArrayList<String> tcp_get = null;

        System.out.println("server> Starting!");

        server = new ServerSocket(80);         

        while (true) {
            System.out.println("server> Waiting on a connection.");

            conn = server.accept();

            System.out.println("server> Obtaining io handles.");

            out = new PrintWriter(conn.getOutputStream(), true);           
            in = new BufferedReader (
                new InputStreamReader (
                    conn.getInputStream()
                )
            );

            System.out.println("server> We get signal.");

            while ((msg = in.readLine()) != null) {
                System.out.println("        " + msg);

                /* done if empty line or null. */
                if (msg.isEmpty()) {
                    System.out.println("-- all client info is read --");
                    break;
                }

                /* additional protocol handling. */
                if (msg.startsWith("GET")) {
                    tcp_get = get_decode(msg);
                }
            }

            System.out.println("server> sending a message to client.");        

            /* send the HTML data. acknowledge? */
            /* header */
            out.write("HTTP/1.0 200 OK\r\n");
            out.write("Content-Type: text/html\r\n");
            out.write("\r\n");

            /* response division. */
            System.out.println("tcp_get empty: " + tcp_get.isEmpty());
            if (!tcp_get.isEmpty()) {
                String page = tcp_get.get(0);

                /* we have a page request. */
                if (isValidPage(page)) {
                    File f = new File(page);

                    try {
                        Scanner br = new Scanner(new FileInputStream(f));
                        String s;

                        while ((s = br.nextLine()) != null) {
                            out.write(s + "\r\n");
                        }

                        br.close();

                        out.write("\r\n");
                        System.out.println("server> closing stream.");        
                    } catch (FileNotFoundException e) {                
                        out.write("<p>ERROR 404!</p>\r\n");
                        out.write("\r\n");
                        System.out.println("sent default message.");
                    } catch (Exception e) {}
                }
                /* once the stream is closed, the client will receive the data."); */
            } else {
                out.write("<p>Welcome to the default page!</p>\r\n");
                out.write("\r\n");
            }
            out.close();

            System.out.println("server> end of communication.");        
        }
    }

    private static boolean isValidPage(String page)
    {
        Pattern pat = Pattern.compile("\\w+\\.html");
        Matcher mat = pat.matcher(page);

        return mat.matches();
    }

    private static ArrayList<String> get_decode(String get) 
    {
        ArrayList<String> tmp = new ArrayList<String>();
        Pattern pat;
        Matcher mat;
        String page;

        String page_pattern = "\\w+\\.html";
        String arg_pattern = "\\w+=\\w+";
        String gt = get.replaceFirst(page_pattern, "");       

        /* obtain the page name. */        
        pat = Pattern.compile(page_pattern);
        mat = pat.matcher(get);

        if (!mat.find()) {
            System.out.println("decode> GET invalid.");    
            return tmp;
        } else {
            page = mat.group();
            System.out.println("GET requests " + page);            
            tmp.add(page);
        }

        /* strip name from get. */
        gt = get.replaceFirst(page_pattern, "");        

        /* obtain the arguments. */
        pat = Pattern.compile(arg_pattern);
        mat = pat.matcher(gt);

        while (mat.find()) {
            System.out.println("argument: " + mat.group());
            tmp.add(mat.group());
        }        

        return tmp;
    }
}