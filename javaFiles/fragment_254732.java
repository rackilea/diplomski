package stackoverflow.answers;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonTest {

  public static void main(String[] arg) {

    Gson gson = new Gson();
    String jsonOutput = "[[\"-1.816513\",\"52.5487566\"],[\"-1.8164913\",\"52.548824\"]]";
    Type listType = new TypeToken<List<List<String>>>() {}.getType();
    List<List<String>> strings = (List<List<String>>) gson.fromJson(jsonOutput, listType);
    for(List<String> inner: strings){
      for(String s: inner){
        System.out.println(s);
      }
    }

  }
}