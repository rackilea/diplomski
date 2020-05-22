import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;

public class ComboBoxExample extends JPanel implements ActionListener
{
    private JComboBox comboBox;

    public ComboBoxExample()
    {
        String[] petStrings = { "Select Pet", "Bird", "Cat", "Dog", "Rabbit", "Pig", "Other" };
        comboBox = new JComboBox( petStrings );
        add( comboBox, BorderLayout.PAGE_START );

        Timer timer = new javax.swing.Timer(2000, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e)
    {
        comboBox.showPopup();
        Object child = comboBox.getAccessibleContext().getAccessibleChild(0);
        BasicComboPopup popup = (BasicComboPopup)child;
        JList list = popup.getList();
        Container c = SwingUtilities.getAncestorOfClass(JScrollPane.class, list);
        JScrollPane scrollPane = (JScrollPane)c;

        Dimension size = scrollPane.getSize();

        if (size.width > 20)
            size.width -= 5;

        scrollPane.setPreferredSize(size);
        scrollPane.setMaximumSize(size);

        Dimension popupSize = popup.getSize();
        popupSize.width = size.width;
        Component parent = popup.getParent();
        parent.setSize(popupSize);

        parent.validate();
        parent.repaint();

        Window mainFrame = SwingUtilities.windowForComponent(comboBox);
        Window popupWindow = SwingUtilities.windowForComponent(popup);

        //  For heavy weight popups you need to pack the window

        if (popupWindow != mainFrame)
            popupWindow.pack();
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame( "ComboBoxExample" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        JComponent newContentPane = new ComboBoxExample();
        newContentPane.setOpaque( true );
        frame.setContentPane( newContentPane );
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}