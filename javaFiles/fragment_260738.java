import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class MenuGlueDemo {

    private Icon errorIcon = UIManager.getIcon("OptionPane.errorIcon");
    private Icon infoIcon = UIManager.getIcon("OptionPane.informationIcon");
    private Icon warnIcon = UIManager.getIcon("OptionPane.warningIcon");

    public MenuGlueDemo() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JButton button = new JButton();
        button.setFocusable(false);
        //button.setMargin(new Insets(0, 0, 0, 0));
        button.setContentAreaFilled(false);
        button.setIcon((errorIcon));
        button.setPressedIcon(warnIcon);
        panel.add(button, BorderLayout.WEST);
        JTextField text = new JTextField(20);
        text.setBorder(null);
        panel.add(text, BorderLayout.CENTER);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setOpaque(false);
        buttonsPanel.setLayout(new GridLayout(1, 2, 2, 2));
        final JToggleButton toggleButton = new JToggleButton();
        toggleButton.setFocusable(false);
        toggleButton.setMargin(new Insets(0, 0, 0, 0));
        toggleButton.setContentAreaFilled(false);
        toggleButton.setIcon((errorIcon));
        toggleButton.setRolloverIcon((infoIcon));
        toggleButton.setSelectedIcon(warnIcon);
        toggleButton.setPressedIcon(warnIcon);
        toggleButton.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (toggleButton.isSelected()) {
                } else {
                }
            }
        });
        buttonsPanel.add(toggleButton);
        final JToggleButton toggleButton1 = new JToggleButton();
        toggleButton1.setFocusable(false);
        toggleButton1.setMargin(new Insets(0, 0, 0, 0));
        toggleButton1.setContentAreaFilled(false);
        toggleButton1.setIcon((errorIcon));
        toggleButton1.setRolloverIcon((infoIcon));
        toggleButton1.setSelectedIcon(warnIcon);
        toggleButton1.setPressedIcon(warnIcon);
        toggleButton1.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (toggleButton1.isSelected()) {
                } else {
                }
            }
        });
        buttonsPanel.add(toggleButton1);
        panel.add(buttonsPanel, BorderLayout.EAST);
        panel.setBackground(text.getBackground());
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createMenu("Menu 1"));
        menuBar.add(createMenu("Menu 2"));
        menuBar.add(createMenu("Menu 3"));
        menuBar.add(new JSeparator());
        menuBar.add(new JButton("   Seach ....  "));
        menuBar.add(panel);
        menuBar.add(new JComboBox(new Object[]{"height", "length", "volume"}));
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(createMenu("About"));
        JFrame frame = new JFrame("MenuGlueDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(menuBar);
        frame.pack();
        frame.setVisible(true);
    }

    private JMenu createMenu(String title) {
        JMenu m = new JMenu(title);
        m.add("Menu item #1 in " + title);
        m.add("Menu item #2 in " + title);
        m.add("Menu item #3 in " + title);
        if (title.equals("About")) {
            m.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        return m;
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                MenuGlueDemo menuGlueDemo = new MenuGlueDemo();
            }
        });
    }
}