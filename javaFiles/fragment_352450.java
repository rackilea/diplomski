import nu.xom.*;

import java.io.File;
import java.io.IOException;

public class RemoveEmptyTags {

    public static void main(String[] args) throws IOException, ParsingException {
        Document document = new Builder().build(new File("original.xml"));
        handleNode(document.getRootElement());
        System.out.println(document.toXML()); // empty elements now removed
    }

    private static void handleNode(Node node) {
        if (node.getChildCount() == 0 && "".equals(node.getValue())) {
            node.getParent().removeChild(node);
            return;
        }
        // recurse the children
        for (int i = 0; i < node.getChildCount(); i++) { 
            handleNode(node.getChild(i));
        }
    }
}