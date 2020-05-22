import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class PullObject {

    private WrappedUrl wrappedUrl;

    public void setWrappedUrl(WrappedUrl wrappedUrl) {
        this.wrappedUrl = wrappedUrl;
    }

    public String fetchJSONString(String url) {
        if (url == null)
            return null;

        StringBuffer bufferedResponse = new StringBuffer();
        try {
            wrappedUrl.setUrl(url);
            HttpURLConnection con = (HttpURLConnection) wrappedUrl.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String inputLine;
            bufferedResponse = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                bufferedResponse.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bufferedResponse.toString();
    }
}