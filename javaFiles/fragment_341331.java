import java.util.HashMap;
import java.util.Map;


interface BaseMethod {
  public void run();
}

class HelloWoldMethod implements BaseMethod {
  public void run() {
    System.out.println("Hello world");
  }

}

class MethodFactory {
  private static MethodFactory ins = null;
  private final static Map<String, BaseMethod> map = new HashMap<String, BaseMethod>();

  private MethodFactory() {
    map.put("hello", new HelloWoldMethod());
  }

  public static BaseMethod getMethod(String key) {
    if (null == ins) {
      ins = new MethodFactory();
    }
    return map.get(key);
  }
}


public class Test {

  public static void main(String [] args) {
    BaseMethod ins = MethodFactory.getMethod("hello");
    if (null != ins) {
      ins.run();

    } else {
      System.out.println("no method found");

    }
  }
}