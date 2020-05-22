import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings("serial")
public class FolderSpecificSyncFrame extends JFrame {

    public FolderSpecificSyncFrame() {
        setTitle("Select Folders to synch from web");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new MultipleCheckBoxesPanel(
                new String[] { "Bananas", "Oranages", "Apples", "Pears", "Bananas", "Oranages",
                        "Apples", "Pears", "Bananas", "Oranages", "Apples", "Pears", "Bananas",
                        "Oranages", "Apples", "Pears", "Bananas", "Oranages", "Apples", "Pears" }));
        pack();
        setSize(250, 300);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FolderSpecificSyncFrame().setVisible(true);
        });
    }

}

@SuppressWarnings("serial")
class MultipleCheckBoxesPanel extends JPanel {
    private ArrayList<JCheckBox> checkBoxes;
    private JCheckBox all;

    public MultipleCheckBoxesPanel(String... options) {
        checkBoxes = new ArrayList<>();
        setLayout(new BorderLayout());
        JPanel header = new JPanel(new FlowLayout(FlowLayout.LEFT, 1, 1));
        all = new JCheckBox("RigFiles (Select All)");

        all.addActionListener((ActionEvent e) -> {
            for (JCheckBox cb : checkBoxes) {
                cb.setSelected(all.isSelected());
            }
        });
        header.add(all);
        add(header, BorderLayout.NORTH);

        JPanel content = new ScrollablePane(new GridBagLayout());
        content.setBackground(Color.WHITE);
        javax.swing.JFileChooser fc = new javax.swing.JFileChooser();
        Icon image = fc.getUI().getFileView(fc).getIcon(new File("."));
        if (options.length > 0) {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.NORTHWEST;
            gbc.insets = new Insets(4, 4, 4, 4);
            gbc.weightx = 1.0; // !!
            gbc.weighty = 1.0;
            gbc.gridy = 0;
            gbc.gridx = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL; // !!

            for (int index = 0; index < options.length; index++) {
                JCheckBox cb = new JCheckBox();
                cb.setOpaque(false);
                checkBoxes.add(cb);
                gbc.anchor = GridBagConstraints.WEST;
                gbc.gridx = 0;
                content.add(cb, gbc);
                // JLabel label = new JLabel(options[index], image, 0);
                JLabel label1 = new JLabel(image);
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.weightx = 0;
                gbc.gridx++;
                content.add(label1, gbc);
                gbc.weightx = 1.0;
                gbc.gridx++;
                JLabel label2 = new JLabel(options[index]);
                content.add(label2, gbc);
                gbc.gridy++;

            }
        }

        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.setBackground(Color.WHITE);
        wrapperPanel.add(content, BorderLayout.PAGE_START);

        add(new JScrollPane(wrapperPanel));
    }
}

@SuppressWarnings("serial")
class ScrollablePane extends JPanel {

    public ScrollablePane(GridBagLayout layout) {
        super(layout);
    }

}