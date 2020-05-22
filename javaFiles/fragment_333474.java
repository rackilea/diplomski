// Extend DefaultListCellRenderer, takes care of most of the work for you
public class ExampleListCellRenderer extends DefaultListCellRenderer
{
    public Component getListCellRendererComponent(
        JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        // I know DefaultListCellRenderer always returns a JLabel
        // super setups up all the defaults
        JLabel label = (JLabel)super.getListCellRendererComponent(list, value, index, isSelect, cellHasFocus);

        // "value" is whatever object you put into the list, you can use it however you want here

        // I'm going to prefix the label text to demonstrate the point

       label.setText("PRE:" + label.getText());

       return label;

    }
}

// Some time later...

JList list = new JList();
list.setCellRenderer(new ExampleListCellRenderer());