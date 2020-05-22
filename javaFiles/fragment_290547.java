import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Lists {

    static String newUrl;
    static DefaultListModel<String> model = new DefaultListModel<String>();
    static int listXCoord = 650;
    static int listYCoord = 10;

    public static void createGUI() {

        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        JButton addurl = new JButton("Add URL");
        panel.add(addurl);
        addurl.addActionListener(new Action1());
        JButton remurl = new JButton("Remove URL");
        panel.add(remurl);

        //model.addElement("one");
        //model.addElement("two");
        //model.addElement("three");
        JList list = new JList<String>(model);
        list.setCellRenderer(new DefaultListCellRenderer());
        list.setVisible(true);
        list.setLocation(listXCoord, listYCoord);
        list.setBackground(new Color(186, 203, 250));
        //list.setLocation(650, 10);

        frame.add(new JScrollPane(list), BorderLayout.EAST);

        frame.setVisible(true);
    }

    static class Action1 implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            newUrl = JOptionPane.showInputDialog("Enter the URL to be Launched");
            model.addElement(newUrl);
        }
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                createGUI();
            }
        });

    }
}