import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class UserInterface implements Runnable {
    final static private int    HEIGHT  = 400;
    final static private int    WIDTH   = 650;

    private String[]            entries = { "Entry 1", "Entry 2", "Entry 3",
            "Entry 4", "Entry 5", "Entry 6" };

    private DefaultListModel    sampleModel;

    public UserInterface() {
        this.sampleModel = new DefaultListModel();
    }

    @Override
    public void run() {
        createPartControl();
    }

    protected void createPartControl() {
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());

        for (int i = 0; i < entries.length; i++) {
            sampleModel.addElement(entries[i]);
        }

        JList sampleList = new JList(sampleModel);
        sampleList.setMinimumSize(new Dimension(1000, 1000));
        sampleList.setMaximumSize(new Dimension(1000, 1000));

        JScrollPane scrollPane = new JScrollPane(sampleList);

        content.add(scrollPane, BorderLayout.CENTER);

        // main window frame
        JFrame window = new JFrame("NAD Assignment 1");
        window.setSize(WIDTH, HEIGHT);
        window.setContentPane(content);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new UserInterface());
    }

}