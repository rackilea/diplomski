import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import com.google.gson.Gson;

public class ReadTest {

public static void main(String[] args) throws IOException {
    String json = FileUtils.readFileToString(new File("json.txt"));

    Gson gson = new Gson();

    A a = gson.fromJson(json, A.class);

    System.out.println(a.width);
    System.out.println(a.numbers[0][0]);
    }
}


public class A {
    public int width;
    public int numbers[][];
}