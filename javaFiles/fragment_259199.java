import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class XmlTest {

    @Test
    public void test() {
        XMLFirstSubclass url = new XMLFirstSubclass("url");
        XMLSecondSubclass xmlSecondSubclassInstance = new XMLSecondSubclass(
                "loc").add("http://goout.cz").appendTo(url);
    }
}

abstract class XML {

    private final List<String> texts = new ArrayList<String>();

    private final List<XML> nodes = new ArrayList<XML>();

    private final String nodeName;

    protected XML(String nodeName) {
        this.nodeName = nodeName;
    }

    @SuppressWarnings("unchecked")
    public <R extends XML> R add(String text) {
        texts.add(text);
        return (R) this;
    }

    @SuppressWarnings("unchecked")
    public <R extends XML, T extends XML> R add(T node) {
        nodes.add(node);
        return (R) this;
    }

    @SuppressWarnings("unchecked")
    public <R extends XML, T extends XML> R appendTo(T node) {
        node.add(this);
        return (R) this;
    }
}

class XMLFirstSubclass extends XML {
    public XMLFirstSubclass(String nodeName) {
        super(nodeName);
    }
}

class XMLSecondSubclass extends XML {
    public XMLSecondSubclass(String nodeName) {
        super(nodeName);
    }
}