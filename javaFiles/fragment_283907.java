import java.io.StringWriter;
import java.util.*;
public class SortedProperties extends Properties {
    @Override public Set<Object> keySet() {
        return Collections.unmodifiableSet(new TreeSet<Object>(super.keySet()));
    }
    @Override public synchronized Enumeration<Object> keys() {
        return Collections.enumeration(new TreeSet<Object>(super.keySet()));
    }
    public static void main(String[] args) throws Exception {
        Properties properties = new SortedProperties() {
            {
                for (int c = 18; c >= 0; c--) {
                    String name = "Button" + (c < 10 ? "0" : "") + c;
                    put(name, name);
                }
            }
        };
        StringWriter stringWriter = new StringWriter();
        properties.store(stringWriter, "foo");
        System.err.println(stringWriter.toString());
    }
    private static final long serialVersionUID = 1L;
}