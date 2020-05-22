import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ComboBoxRenderer extends JLabel implements ListCellRenderer
{
    private Color selectionBackgroundColor;
    private Color defaultBackgroundColor;
    private DefaultListCellRenderer dlcr = new DefaultListCellRenderer();

    // Constructor
    public ComboBoxRenderer()
    {
        setOpaque(true);
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
        defaultBackgroundColor = this.dlcr.getBackground(); // Have to set a color, else a compiler error will occur
    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        // Set the list background color to default color (default color will show once selection is made)
        selectionBackgroundColor = null;
        Color mouseHoverHighlight = Color.LIGHT_GRAY;
        setText((String)value);
        // Check which item is selected
        if(isSelected)
        {
            // Set background color of the item your cursor is hovering over to the original background color
            String selectedText = getText();
            if (selectedText.equals("SelectedTextOne")){
                list.setSelectionBackground(Color.GREEN);
            } else if (selectedText.equals("SelectedTextTwo")){
                list.setSelectionBackground(Color.RED);
            } else {
                list.setSelectionBackground(defaultBackgroundColor);
            }
            setBackground(mouseHoverHighlight);
        }
        else
        {
            // Set background to specific color depending on text value
            String selectedTextInDropdownList = getText();
            if (selectedTextInDropdownList.equals("SelectedTextOne")) {
                selectionBackgroundColor = Color.GREEN;
            } else if (selectedTextInDropdownList.equals("SelectedTextTwo")) {
                selectionBackgroundColor = Color.RED;
            } else {
                selectionBackgroundColor = defaultBackgroundColor;
            }
        }


        return this;
    }

    @Override
    public boolean isOpaque() {
        return true;
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Color getBackground() {
        return selectionBackgroundColor == null ? super.getBackground() : selectionBackgroundColor;
    }
}