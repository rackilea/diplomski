import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jessie on 14-07-09.
 */
public class TestGson {
    private static String JSON = "{\"htmlMessage\":\"text\",\"Attachments\":{\"8216096_0\":{\"content\":null,\"filename\":\"plk.jpg\",\"contentType\":\"image/jpeg\",\"contentDisposition\":\"attachment\",\"size\":86070}}}\n";

    public static void main(String[] args) {
        JsonObject json = new JsonParser().parse(JSON).getAsJsonObject();
        JsonObject attachments = json.getAsJsonObject("Attachments");

        List<JsonObject> attachmentsList = new ArrayList<JsonObject>();
        for( Map.Entry<String, JsonElement> attachment : attachments.entrySet()) {
            attachmentsList.add(attachment.getValue().getAsJsonObject());
        }

        System.out.println("attachmentsList at the end? " + attachmentsList);
    }
}