import java.net.*;

public class Action 
{

    public static void main(String[] args)
    {
        try
        {
            URL url = new URL("http://localhost:8888");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int code = connection.getResponseCode();  
            System.out.println("code: "+code);
        }
        catch(Exception e)
        {

        }

    }
}