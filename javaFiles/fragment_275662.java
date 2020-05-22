import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class ScrollSizeRedone {
    public static void main(final String[] args) {

        final JFrame frame = new JFrame();

        final JTable table = new JTable(new DefaultTableModel(new String[][] { { "a", "b" }, { "c", "d" } }, new String[] { "col1", "col2" }));
        final JScrollPane pane = new JScrollPane(table);
        //      pane.setBounds(0, 0, 415, 50); // < ---This seems to do nothing // no use
        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        final JPanel completePanel = new JPanel();
        completePanel.setLayout(new BorderLayout());
        completePanel.add(pane);

        final JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        buttonsPanel.add(new JButton("LOL"));
        buttonsPanel.add(Box.createHorizontalStrut(100));
        buttonsPanel.add(new JButton("ROFL"));
        buttonsPanel.add(Box.createHorizontalGlue());
        buttonsPanel.add(new JButton("MUAHAHA"));
        completePanel.add(buttonsPanel, BorderLayout.SOUTH);

        final JTabbedPane jtp = new JTabbedPane();
        //      jtp.setBounds(-11, -14, 436, 170); // <---- I used -ve to hide border
        jtp.addTab("tab1", new JLabel("Tab1"));
        jtp.addTab("tab2", new JLabel("Tab2"));
        jtp.addTab("tab3", new JLabel("Tap3"));
        jtp.addTab("tab4", new JLabel("Tab4"));
        jtp.addTab("tab5", completePanel);

        jtp.setTabPlacement(JTabbedPane.BOTTOM);
        frame.add(jtp, BorderLayout.CENTER);

        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}