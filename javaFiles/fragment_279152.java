import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

class PullObject {

    private WrappedUrl wrappedUrl;

    private HttpURLConnection connection;

    private BufferedReader bufferedReader;

    PullObject(String url) {
        wrappedUrl = new WrappedUrl(url);
        connection = (HttpURLConnection) wrappedUrl.openConnection();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    void setWrappedUrl(WrappedUrl wrappedUrl) {
        this.wrappedUrl = wrappedUrl;
    }

    void setConnection(HttpURLConnection connection) {
        this.connection = connection;
    }

    void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    String fetchJSONString(String url) {
        if (url == null)
            return null;

        StringBuffer bufferedResponse = new StringBuffer();
        try {
            connection.setRequestMethod("GET");
            String inputLine;
            bufferedResponse = new StringBuffer();

            if (bufferedReader != null) {
                while ((inputLine = bufferedReader.readLine()) != null) {
                    bufferedResponse.append(inputLine);
                }
                bufferedReader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bufferedResponse.toString();
    }
}