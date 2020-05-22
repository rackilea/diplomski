import org.dom4j.*;
import org.dom4j.tree.*;

// ...

public void insertProcessingInstructions(Element element) {
    List nodes = element.content();
    final String splitter = " and ";
    int index = 0;
    while (index < nodes.size()) {
        if (nodes.get(index) instanceof Text) {
            Text textNode = (Text)nodes.get(index);
            String text = textNode.getText();
            int andPos = text.indexOf(splitter);
            if (andPos >= 0) {
                String beforeText = text.substring(0, andPos);
                String afterText = text.substring(andPos + splitter.length());
                textNode.setText(beforeText);
                nodes.add(index + 1, new DefaultProcessingInstruction("Pub", "_newline"));
                nodes.add(index + 2, new DefaultText(splitter.trim()));
                nodes.add(index + 3, new DefaultProcessingInstruction("Pub", "_newline"));
                nodes.add(index + 4, new DefaultText(afterText));
                // Move to the last Text node created, in case it contains another
                // occurrence of the splitter string.
                index += 4; 
            } else {
                // No more occurrences of the splitter string in this Text node.
                ++index;
            }
        } else {
            // Not a Text node.
            ++index;
        }
    }
}