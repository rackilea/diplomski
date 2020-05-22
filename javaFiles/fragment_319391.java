import java.io.FileOutputStream;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

public class Main{
  public static void main(String[] args) throws Exception {
    SortedProperties sp = new SortedProperties();
    sp.put("B", "value B");
    sp.put("C", "value C");
    sp.put("A", "value A");
    sp.put("D", "value D");
    FileOutputStream fos = new FileOutputStream("sp.props");
    sp.store(fos, "sorted props");
  }

}
class SortedProperties extends Properties {
  public Enumeration keys() {
     Enumeration keysEnum = super.keys();
     Vector<String> keyList = new Vector<String>();
     while(keysEnum.hasMoreElements()){
       keyList.add((String)keysEnum.nextElement());
     }
     Collections.sort(keyList);
     return keyList.elements();
  }

}