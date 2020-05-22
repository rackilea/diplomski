import com.google.gson.Gson;
import lombok.ToString;

import java.util.List;

public class GsonTest {
    public static void main(String[] args) {
        String json = "{\"list\":[]}";
        Gson g = new Gson();
        Pojo pojo = g.fromJson(json, Pojo.class);
        System.out.println(pojo.list.size());
        System.out.println(pojo);
    }
}

@ToString
class Pojo {
    List<Object> list;
}