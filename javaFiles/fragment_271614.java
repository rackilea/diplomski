import java.util.ArrayList;

public class Foo {
    ArrayList<Double> msgstoboo = new ArrayList<Double>();

    public Foo(int numofmessages) {
        for (int i = 0; i < numofmessages; i++) {
            msgstoboo.add(Double.valueOf(1));
        }
    }

    public void setMsg(int index, double input) {
        msgstoboo.set(index, input);
    }
}