import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class CutoffConverter implements Converter{

      @SuppressWarnings("unchecked")
      public boolean canConvert(Class type) {
        return type.equals(FirefoxDriver.class);
      }

      public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
      }

      public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
          return null;
      }
}