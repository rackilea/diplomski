import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ButtonCombo {

    private JPanel getContent() throws MalformedURLException {
        String[] ids = {"north", "west", "south", "east"};
        JComboBox combo = new JComboBox(ids);
        Icon removeIcon = new ImageIcon(new URL("http://filesharefreak.org/images/red_x.png"));
        combo.setRenderer(new ButtonComboRenderer(removeIcon, combo));
        JPanel panel = new JPanel();
        panel.add(combo);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    JFrame f = new JFrame();
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    JPanel panel = new JPanel();
                    panel.add(new ButtonCombo().getContent());
                    JButton button = new JButton("OKOKO");
                    panel.add(button);
                    f.setContentPane(panel);
                    f.setSize(300, 160);
                    f.setLocation(200, 200);
                    f.setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(ButtonCombo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}

class ButtonComboRenderer implements ListCellRenderer {
    Icon icon;
    JPanel panel;
    JLabel label;
    JButton button;

    public ButtonComboRenderer(Icon removeIcon, final JComboBox combo) {
        icon = removeIcon;
        label = new JLabel();
        button = new JButton(icon);
        button.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        panel = new JPanel(new BorderLayout());
        panel.add(label);
        panel.add(button, BorderLayout.EAST);
        panel.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                if (button.getX() < e.getX()) {
                    System.out.println("button contains the click remove the item");
                    combo.removeItem(label.getText());
                }
            }
        });
    }
    //so we will install the mouse listener once
    boolean isFirst = true;

    @Override
    public Component getListCellRendererComponent(JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {
        if (isFirst) {
            isFirst = false;
            list.addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                    panel.dispatchEvent(e);
                    e.consume();
                }
            });
        }
        String text = (String) value;
        label.setText(text);
        if(text == null)
            button.setIcon(null);
        else if(button.getIcon() == null)
            button.setIcon(icon);
        panel.setBackground(isSelected ? Color.red : Color.white);
        panel.setForeground(isSelected ? Color.white : Color.black);
        return panel;
    }
}