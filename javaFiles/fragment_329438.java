import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.text.*;

public class HighlightGroup {
    private final List<String> textFragments;
    private final Color color;
    private final AttributeSet attributeSet;

    public HighlightGroup(List<String> textFragments, Color color) {
        this.textFragments = new ArrayList<>(textFragments);
        this.color = color;

        StyleContext styleContext = StyleContext.getDefaultStyleContext();
        this.attributeSet = styleContext.addAttribute(styleContext.getEmptySet(),
                                                      StyleConstants.Foreground,
                                                      color);
    }

    public List<String> getTextFragments() {
        return textFragments;
    }

    public Color getColor() {
        return color;
    }

    public void highlightWords(JTextPane textPane) {
        String text = textPane.getText();
        StyledDocument styledDocument = textPane.getStyledDocument();
        for (String textFragment : textFragments) {
            int fromIndex = 0;
            int startIndex = text.indexOf(textFragment, fromIndex);
            while (startIndex != -1) {
                // Change the color of recognized text fragments.
                styledDocument.setCharacterAttributes(startIndex, textFragment.length(),
                                                      attributeSet, false);

                fromIndex = startIndex + textFragment.length();
                startIndex = text.indexOf(textFragment, fromIndex);
            }
        }
    }
}