import java.awt.*;
import javax.swing.*;
import java.util.Set;

public class L extends JFrame {
    private TMap t;

    public L() {
        t = new TMap();
    }

    public Set<String> getKeySet() {
        return t.getKeySet();
    }

    public Integer get(String s) {
        return t.get(s);
    }

    // your main method as before
}