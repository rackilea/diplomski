import java.net.HttpURLConnection;
import java.net.URL;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;

public class Soapy2 {
    public static void main(String args[]) throws Exception {
        // W3C's API works on HTML, so set up an HTML connection
        URL url = new URL("http://validator.w3.org/check?output=soap12&uri=http://www.example.com");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        //Wrap the output from your HTTP connection into an InputStream and feed it into an instance of SOAPMessage
        SOAPMessage response = MessageFactory.newInstance().createMessage(null, connection.getInputStream());

        // Close the connection once the data has been collected
        connection.disconnect();

        //Send the SOAP output to an OutputStream of your choice (e.g. the console)
        response.writeTo(System.out);
    }
}