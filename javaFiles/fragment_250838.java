import com.google.gson.*;

public class Main {

    public static void main(String[] args) {
        String json = "{\"created_at\":\"Sat Jun 15 19:21:29 +0000 2019\",\"text\":\"RT @BuzzTechy: [BEST] Udemy Course - Create a Python Powered Chatbot in Under 60 Minutes  \\n\\nsomeUrl \\n\\n#AI #Python #Chatbot?\",\"source\":\"<a href=\\\"https://allentowngroup.com\\\" rel=\\\"nofollow\\\">bobbidigi</a>\",\"truncated\":false,\"in_reply_to_screen_name\":\"asdsf\",\"user\":{\"id\":1724601306,\"name\":\"Rob's Coding News In The Hood\"}}";
        Gson g = new GsonBuilder()
                .registerTypeAdapter(TweetEntity.class, new TweetEntityDeserializer())
                .create();
        TweetEntity entity = g.fromJson(json, TweetEntity.class);
        System.out.println("created at: " + entity.getCreatedAt());
        System.out.println("userName: " + entity.getUserName());
    }

}