package dummy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class ATransport{}
class BTransport{}
class A implements Transportable<ATransport> {
  public ATransport getTransport() {
    ATransport at=new ATransport();
    return at;
  }
}
class B implements Transportable<BTransport> {
  public BTransport getTransport() {
    BTransport bt=new BTransport();
    return bt;
  }
}
class X {
    public static <U, T extends Transportable<U>> List<U> getTransport(List<T> list) {
        List<U> ret = new LinkedList<>();
        for (T t : list) {
            ret.add(t.getTransport());
        }
        return ret;
    }

    public static void main(String[] args) {
        List<BTransport> transportsB = getTransport(Collections.singletonList(new B()));
        List<ATransport> transportsA = getTransport(Collections.singletonList(new A()));
    }
}