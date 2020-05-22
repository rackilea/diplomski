import javax.swing.*;
import java.awt.*;

public class Monitor {

    public static void main(String[] args){
        Runnable r = new Runnable() {
            public void run() {
                JFrame frame = new JFrame("WELCOME");
                // A better close operation..
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JTabbedPane tab = new JTabbedPane();
                frame.add(tab, BorderLayout.CENTER);
                JButton button = new JButton("1");
                tab.add("tab1", button);

                // this GridLayout will create a single row of components,
                // with equal space for each component
                JPanel tab2Panel = new JPanel(new GridLayout(1,0));
                button = new JButton("2");
                tab2Panel.add(button);
                tab2Panel.add(new JButton("long name to stretch frame"));
                // add the panel containing two buttons to the tab
                tab.add("tab2", tab2Panel);

                button = new JButton("3");
                tab.add("tab3", button);
                // a better sizing method..
                //frame.setSize(400,400);
                frame.pack();
                frame.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}