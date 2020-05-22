package net.custom.streamhandler.apacheftp;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;


public class ApacheURLStreamHandlerFactory implements URLStreamHandlerFactory { 
    public URLStreamHandler createURLStreamHandler(String protocol) { 
        //this will only override the chosen protocol  
        if ( protocol.equalsIgnoreCase("ftp") ) 
            return new CustomHandler(); 
        else 
            return null;
    } 
}
class CustomHandler extends URLStreamHandler { 
    protected URLConnection openConnection(URL url) 
       throws IOException { 
        return new CustomURLConnection(url); 
    } 
} 

class CustomURLConnection extends URLConnection { 

    int reply;
    FTPClient ftp = new FTPClient();
    InputStream in;
    static int defaultPort = 21; 
    static String defaultPath = "/"; 

    CustomURLConnection ( URL url) 
        throws IOException { 
        super( url ); 
    } 
    synchronized public void connect() throws IOException {  
            try {
                int port; 
                if ((port = url.getPort()) == -1 ) 
                    port = defaultPort; 

                ftp.connect(url.getHost(), port);
                String login = "anonymous";
                String password = "";
                if(url.getAuthority().indexOf(':')>-1 && 
                        url.getAuthority().indexOf('@')>-1){
                            String []auxArray = url.getAuthority().replaceAll("@", ":").split(":");
                            login = auxArray[0];
                            password = auxArray[1];
                }               

                ftp.login(login, password);             

                reply = ftp.getReplyCode();
                if (FTPReply.isPositiveCompletion(reply)) {
                    System.out.println("Connected Apache Success");
                } else {
                    System.out.println("Connection Apache Failed");
                    ftp.disconnect();
                }
                in = ftp.retrieveFileStream(url.getFile());

            } catch (SocketException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        connected = true;        

    } 
    synchronized public InputStream getInputStream() 
       throws IOException { 
        if (!connected) 
            connect(); 
        return ( in );  
    }  
}