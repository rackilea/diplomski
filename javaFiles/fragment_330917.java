package json;
import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class UseJson {
  public static void main(String[] args) throws Exception {
    ObjectMapper om = new ObjectMapper();
    String json = "{\r\n" + 
    "  \"test\": [\r\n" + 
    "    1,\r\n" + 
    "    2,\r\n" + 
    "    3,\r\n" + 
    "    4\r\n" + 
    "  ]\r\n" + 
    "} ";
    System.out.println("json="+json);
    Wrap val = om.readValue( json, Wrap.class);
    System.out.println("read val="+val);
    val.test.add(0);
    Collections.sort(val.test);
    System.out.println("val="+val);
    om.enable(SerializationFeature.INDENT_OUTPUT);
    String json2 = om.writeValueAsString(val);
    System.out.println("json2="+json2);
  }
}

class Wrap {
  public List<Integer> test;
  @Override
  public String toString() {
    return "Wrap[test=" + test + "]";
  }
}