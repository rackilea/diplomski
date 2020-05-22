import com.google.gson.*;
import java.lang.reflect.Type;


public class TweetEntityDeserializer implements JsonDeserializer<TweetEntity> {

    @Override
    public TweetEntity deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonElement user = json.getAsJsonObject().get("user");
        JsonElement userName = user.getAsJsonObject().get("name");

        Gson g = new GsonBuilder().setDateFormat("E MMM dd hh:mm:ss Z yyyy").create();
        TweetEntity entity = g.fromJson(json, TweetEntity.class);
        entity.setUserName(userName.getAsString());
        return entity;
    }

}