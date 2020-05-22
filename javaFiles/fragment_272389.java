import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;


class CustomComboBoxRenderer extends JTextField implements ListCellRenderer
{
public CustomComboBoxRenderer()
{
    this.setBorder(BorderFactory.createCompoundBorder( this.getBorder(), 
            BorderFactory.createEmptyBorder(15, 0, 10, 0)));
}


@Override
public Component getListCellRendererComponent(JList list, Object value,
        int index, boolean isSelected, boolean cellHasFocus) {
    if (isSelected) {
        setBackground(list.getSelectionBackground());
        setForeground(list.getSelectionForeground());
    } else {
        setBackground(list.getBackground());
        setForeground(list.getForeground());
    }
    this.setText(value.toString());
    return this;
}

}
public class Gui extends JFrame{

JPanel panel = new JPanel();
String[] data = new String[]{"A","B","C","D","E","F"};
ComboBoxModel model = new DefaultComboBoxModel(data);
JComboBox combo = new JComboBox(model);
CustomComboBoxRenderer renderer = new CustomComboBoxRenderer();

public  Gui()
{
    combo.setRenderer(renderer);
    JPanel content = new JPanel();
    content.add(combo);
    setContentPane(content);
    pack();
    setLocation(300,300);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}

public static void main(String[] args)
{
    new Gui();
}

}