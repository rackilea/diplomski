// First, declare the 'a' tags in the root class hosting them (this is pretty standard):
@ElementList(entry = "a", inline = true) List<A> aList;

// Second, create and apply a custom converter as described:
@Root
@Convert(CustomConverter.class)
public class A {
    String content = "";

    public String getContent() {
        return content;
    }
}

public class CustomConverter implements Converter<A> {

    @Override
    public A read(InputNode node) throws Exception {
        A a = new A();

        String value = node.getValue();
        if (value != null) {
            a.content = value;
        }

        InputNode nodeB = node.getNext();
        if (nodeB != null) {
            value = nodeB.getValue();
            if (value != null) {
                a.content += value;
            }
        }

        return a;
    }

    @Override
    public void write(OutputNode node, A value) throws Exception {
        // N/A
    }
}