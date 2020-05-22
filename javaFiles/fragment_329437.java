import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.text.*;

public class CustomDocumentFilter extends DocumentFilter
{
    private final JTextPane textPane;
    private final List<HighlightGroup> highlightGroups;

    private final StyleContext styleContext = StyleContext.getDefaultStyleContext();
    private final AttributeSet blackAttributeSet
            = styleContext.addAttribute(styleContext.getEmptySet(),
                                        StyleConstants.Foreground, Color.BLACK);

    public CustomDocumentFilter(JTextPane textPane) {
        this.textPane = textPane;

        highlightGroups = createHighlightGroups();
        ((AbstractDocument) textPane.getDocument()).setDocumentFilter(this);
    }

    private List<HighlightGroup> createHighlightGroups() {
        List<HighlightGroup> groups = new ArrayList<>();
        groups.add(new HighlightGroup(Arrays.asList("one", "two", "three"), Color.RED));
        groups.add(new HighlightGroup(Arrays.asList("a", "the"), Color.ORANGE));
        groups.add(new HighlightGroup(Arrays.asList("th", "o"), Color.BLUE));
        return groups;
    }

    public List<HighlightGroup> getHighlightGroups() {
        return highlightGroups;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String text,
                             AttributeSet attributeSet) throws BadLocationException {
        super.insertString(fb, offset, text, attributeSet);

        handleTextChanged();
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length)
            throws BadLocationException {
        super.remove(fb, offset, length);

        handleTextChanged();
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text,
                        AttributeSet attributeSet) throws BadLocationException {
        super.replace(fb, offset, length, text, attributeSet);

        handleTextChanged();
    }

    /**
     * Runs your updates later, not during the event notification.
     */
    public void handleTextChanged()
    {
        SwingUtilities.invokeLater(this::updateTextStyles);
    }

    private void updateTextStyles()
    {
        // Reset the existing styles by using the default black style for all text.
        StyledDocument document = textPane.getStyledDocument();
        document.setCharacterAttributes(0, textPane.getText().length(),
                                        blackAttributeSet, true);

        // Apply styling for the different groups (the order of the groups is relevant).
        for (HighlightGroup highlightGroup : highlightGroups) {
            highlightGroup.highlightWords(textPane);
        }
    }
}