import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.testgson.beans.User;

public class Main {
    private static Gson gson;

    static {
        gson = new GsonBuilder().create();
    }

    public static void main(String[] args) {
        String j = "{\"id\":1,\"lastName\":\"lastName\",\"name\":\"ignacio\",\"school\":{\"id\":1}}";
        User u = gson.fromJson(j, User.class);
        System.out.println(u);
    }
}