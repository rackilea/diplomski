import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class testclass implements ItemListener {

JPanel template;
final static String title = "Title";
final String dir = "images/";

public void testclass(Container window) {

    JPanel index = new JPanel();

    String[] index2 = { title };
    JComboBox index3 = new JComboBox(index2);
    index3.setEditable(false);
    index3.addItemListener(this);
    index.add(index3);
    index.setSize(500, 500);

    File folder = new File(dir);
    File[] listOfFiles = folder.listFiles();

    String nr;
    final JPanel panel = new JPanel(new GridLayout(4, 4, 4, 4));

    for (int i = 0; i < listOfFiles.length; i++) {
        nr = dir + listOfFiles[i].getName();

        panel.add(new ImageButton(nr));

    }

    template = new JPanel(new CardLayout());
    template.add(panel, title);

    window.add(template, BorderLayout.CENTER);
    window.add(index, BorderLayout.NORTH);

    window.setVisible(true);
}

public void itemStateChanged(ItemEvent event) {

    CardLayout change = (CardLayout) (template.getLayout());
    change.show(template, (String) event.getItem());
}

private static void userinterface() {

    JFrame showwindow = new JFrame("Window");
    showwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    testclass show = new testclass();
    show.testclass(showwindow.getContentPane());

    showwindow.pack();
    showwindow.setVisible(true);
    showwindow.setSize(500, 500);
}

public static void main(String[] args) {
    try {
        UIManager
                .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    } catch (Exception e) {
    }
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            userinterface();
        }
    });
}
}