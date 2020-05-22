import sun.misc.IOUtils;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Program {


    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");

        String address = "https://www.groupon.pl/deals/ga-hotel-alpin-17";
        URL url = new URL(address);
        URLConnection httpcon = url.openConnection();
        httpcon.setConnectTimeout(5000);
        httpcon.setReadTimeout(5000);

//        httpcon.addRequestProperty("Host", "www.groupon.pl");
        httpcon.addRequestProperty("User-Agent", "Mozilla/5.0 (X11; Fedora; Lin… Gecko/20100101 Firefox/54.0");
//        httpcon.addRequestProperty("Accept", "text/html,application/xhtml+x…lication/xml;q=0.9,*/*;q=0.8");
//        httpcon.addRequestProperty("Accept-Language", "en-US,en;q=0.5");
        httpcon.addRequestProperty("Accept-Encoding", "utf-8");
//        httpcon.addRequestProperty("DNT", "1");
//        httpcon.addRequestProperty("Connection", "keep-alive");
//        httpcon.addRequestProperty("Upgrade-Insecure-Requests", "1");

        InputStream response = httpcon.getInputStream();



        Scanner scanner = new Scanner(response);
        String responseBody = scanner.useDelimiter("\\A").next();
        String title = responseBody.substring(responseBody.toUpperCase().indexOf("<TITLE>") + 7, responseBody.toUpperCase().indexOf("</TITLE>"));

        System.out.println("End!" + title);
    }
}