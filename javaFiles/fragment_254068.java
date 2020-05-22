import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import org.json.*;

public class ImageListProcessor
{
    public static ArrayList<URL> processList(InputStream toProcess, URL baseURL)
        throws JSONException, MalformedURLException
    {
        JSONTokener toProcessTokener = new JSONTokener(toProcess);
        JSONObject toProcessResponse = new JSONObject(toProcess);
        if (!toProcessResponse.isNull("error")) {
            // it's an error response, probably a good idea to get out of here
            throw new JSONException("Response contains error: " + toProcessResponse.get("error"));
        }
        JSONArray toProcessArray = toProcessResponse.getJSONArray("items");
        int len = toProcessArray.length();
        ArrayList<URL> result = new ArrayList<URL>(len);
        for(int i = 0; i < len; i++) {
            JSONObject imageRecord = toProcessArray.getJSONObject(i);
            String imagePath = imageRecord.getString("image");
            // if you want to remove the date portion of the path:
            imagePath = imagePath.substring(1 + imagePath.lastIndexOf('/'));
            URL combinedURL = new URL(baseURL, imagePath);
            result.add(combinedURL);
        }
        return result;
    }
}