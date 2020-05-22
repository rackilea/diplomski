import com.thoughtworks.xstream.converters.*;
import com.thoughtworks.xstream.io.*;

public class ValueAttributeConverter implements Converter {
  public boolean canConvert(Class cls) {
    return (cls == String.class);
  }

  public void marshal(Object source, HierarchicalStreamWriter w, MarshallingContext ctx) {
    w.addAttribute("value", (String)source);
  }

  public Object unmarshal(HierarchicalStreamReader r, UnmarshallingContext ctx) {
    return r.getAttribute("value");
  }
}