import java.net.*;
    import java.io.*;

    public class URLConnectionReader {
        public static void main(String[] args) throws Exception {
            URL facebook = new URL("http://www.facebook.com/or any dir");
            URLConnection yc = facebook.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                                        yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) 
                System.out.println(inputLine);
            in.close();
        }
    }