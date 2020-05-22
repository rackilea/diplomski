import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class AccessoryFileChooser2 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JFileChooser chooser = null;
    private JLabel statusbar;
    private JLabel file;
    private JCheckBox checkBox;
    private int count;
    private int increment = 10;
    private JPanel parentPanel = new JPanel();
    private JPanel panels = new JPanel();
    private JPanel[] panel = new JPanel[increment]; //array
    private JButton accButton = new JButton("Browse");
    private JButton addButton = new JButton("Add");
    private JButton validate = new JButton("Validate");
    private JButton delete = new JButton("Delete");

    public AccessoryFileChooser2() {
        count = 0;
        parentPanel.setLayout(new GridLayout(10, 1, 10, 10));
        checkBox = new JCheckBox("");
        String fileName = "Choose File Name";
        file = new JLabel(fileName);
        accButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                int option = chooser.showOpenDialog(AccessoryFileChooser2.this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    statusbar.setText((chooser.getSelectedFile().getPath()));
                }
            }
        });
        statusbar = new JLabel("Output of your selection will go here");
        chooser = new JFileChooser();
        panel[count] = new JPanel();
        panel[count].add(checkBox);
        panel[count].add(file);
        panel[count].add(accButton);
        panel[count].add(statusbar);
        panel[count].setPreferredSize(new Dimension(450, 40));
        panel[count].setBorder(new LineBorder(Color.BLACK, 1));
        parentPanel.add(panel[count]);
        addButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (count < increment - 1) {
                    count += 1;
                    panel[count] = new JPanel();
                    System.out.println("You clicked the ADD button");
                    panel[count].add(checkBox);
                    panel[count].add(file);
                    panel[count].add(accButton);
                    panel[count].add(statusbar);
                    panel[count].revalidate();
                    panel[count].repaint();
                    //panel[count].updateUI();
                    parentPanel.add(panel[count]);
                    parentPanel.revalidate();
                    parentPanel.repaint();
                    pack();
                    if (count == increment - 1) {
                        addButton.setEnabled(false);
                    }
                }
            }
        });
        delete.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked the Delete button");
                System.out.println(checkBox.isSelected());
                /*for (int i = 0; i < parentPanel.getComponentCount(); i++) {
                JCheckBox box = (JCheckBox) panel[i].getComponent(0);
                if (box.isSelected()) {
                parentPanel.remove(panel[i]);
                }
                }*/
            }
        });
        validate.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked the Validate button");
            }
        });
        panels.setLayout(new GridLayout(1, 3, 10, 10));
        panels.add(addButton);
        panels.add(delete);
        panels.add(validate);
        add(parentPanel, BorderLayout.CENTER);
        add(panels, BorderLayout.SOUTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String args[]) {
        AccessoryFileChooser2 afc = new AccessoryFileChooser2();
    }
}