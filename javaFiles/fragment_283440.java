import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.svenson.JSONParser;

public class Test {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        parser.addTypeHint(".Example[]", Example.class);
        String json = "{" + "\"Example\": [" + "{" + "\"foo\": \"a1\","
                + "\"bar\": \"b1\"," + "\"fubar\": \"c1\"" + "}," + "{"
                + "\"foo\": \"a2\"," + "\"bar\": \"b2\"," + "\"fubar\": \"c2\""
                + "}," + "{" + "\"foo\": \"a3\"," + "\"bar\": \"b3\","
                + "\"fubar\": \"c3\"" + "}" + "]" + "}\"";
        parser.addTypeHint("Example[]", Example.class);
        Map<String, List<Example>> result1 = parser.parse(Map.class, json);
        for (Entry<String, List<Example>> entry : result1.entrySet()) {
            for (Example example : entry.getValue()) {
                System.out.println("VALUE :->" + example.getFoo());
            }
        }
    }
}

public class Example {
    private String foo;
    private String bar;
    private String fubar;
    public Example(){}
    public void setFoo(String foo) {
        this.foo = foo;
    }
    public String getFoo() {
        return foo;
    }
    public void setBar(String bar) {
        this.bar = bar;
    }
    public String getBar() {
        return bar;
    }
    public void setFubar(String fubar) {
        this.fubar = fubar;
    }
    public String getFubar() {
        return fubar;
    }
}