import java.net.*;
import java.io.*;

public class ParseURL {
    public static void main(String[] args) throws Exception {

        String url = "http://v20.lscache8.c.youtube.com/videoplayback?id=271de9756065677e&itag=17&ip=0.0.0.0&ipbits=0&expire=999999999999999999"&sparams=ip,ipbits,expireip,ipbits,expire,id,itag&signature=3DCD3F79E045F95B6AF661765F046FB0440FF01606A42661B3AF6BAF046F012549CC9BA34EBC80A9";
        URL aURL = new URL(url);

        System.out.println("protocol = " + aURL.getProtocol());
        System.out.println("authority = " + aURL.getAuthority());
        System.out.println("host = " + aURL.getHost());
        System.out.println("port = " + aURL.getPort());
        System.out.println("path = " + aURL.getPath());
        System.out.println("query = " + aURL.getQuery());
    }
}