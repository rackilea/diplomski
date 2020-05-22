import java.util.Map;
import com.google.gson.Gson;

public class Scratch {
    public static void main(String[] args) throws Exception {
        String json = "{ \"labels\": { \"kubernetes.io/hostname\": \"192.168.200.176\", \"node\": \"master\" } }";

        Library library = new Gson().fromJson(json, Library.class);
        System.out.println(library.labels);
        // {kubernetes.io/hostname=192.168.200.176, node=master}
    }
}

class Library {
    Map<String, String> labels;
}