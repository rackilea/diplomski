import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.nio.file.Files;

public class OrgJsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();
        String json = String.join("", Files.readAllLines(jsonFile.toPath()));

        JSONObject response = new JSONObject(json);

        // get items
        JSONArray jsonItemsArray = response.getJSONArray("items");
        for (int i = 0; i < jsonItemsArray.length(); i++) {
            String thumbnailUrl = "";
            JSONObject item = jsonItemsArray.getJSONObject(i);
            JSONObject volumeInfo = item.getJSONObject("volumeInfo");
            JSONObject thumbnailUrlObject = volumeInfo.optJSONObject("imageLinks");
            if (thumbnailUrlObject != null && thumbnailUrlObject.has("thumbnail")) {
                thumbnailUrl = thumbnailUrlObject.getString("thumbnail");
            }
            String title = volumeInfo.getString("title");
            System.out.println("title => " + title);
            System.out.println("thumbnail => " + thumbnailUrl);
        }
    }
}