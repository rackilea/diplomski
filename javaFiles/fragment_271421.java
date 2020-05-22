import java.util.*;
import java.util.stream.*;

class Test {
  public static void main(String[] args) {
    List<Object> list = new ArrayList<Object>();
    for(int i=0; i<100000; i++) {
      list.add(new Integer(i));
    }
    new Test().listToMap(list);
  }

    Map<Integer, Object> listToMap(List<Object> objs) {
        return objs.stream().collect(Collectors.toMap(Object::hashCode, obj -> obj));
    }
}