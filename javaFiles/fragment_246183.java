import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

@SuppressWarnings("serial")
public class Draft2 extends JPanel {
    private List<MyItem> selectedItems = new ArrayList<>();
    private NumberFormat formatter = NumberFormat.getCurrencyInstance();
    private double total;
    private JLabel totalAmountLabel = new JLabel(formatter.format(total));
    private DefaultComboBoxModel<MyItem> comboModel = new DefaultComboBoxModel<>();
    private JComboBox<MyItem> menuCombo = new JComboBox<>(comboModel);

    public Draft2() {
        // monospaced to make names and price line up
        menuCombo.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));

        // fill the JComboBox with items
        comboModel.addElement(new MyItem("Baseball", 21.5));
        comboModel.addElement(new MyItem("Bat", 50.8));
        comboModel.addElement(new MyItem("Football", 22.26));

        // create a JPanel to hold selection components and add components
        JPanel selectionPanel = new JPanel();
        selectionPanel.add(new JLabel("Menu:"));
        selectionPanel.add(menuCombo);
        selectionPanel.add(new JButton(new AcceptAction("Accept", KeyEvent.VK_A)));

        // create a JPanel to hold the total amount information
        JPanel totalAmountPanel = new JPanel();
        totalAmountPanel.add(new JLabel("Total Amount:"));
        totalAmountPanel.add(totalAmountLabel);

        // create a JPanel to hold buttons, uses grid layout with a single row  
        JPanel btnPanel = new JPanel(new GridLayout(1, 0, 5, 0)); 
        btnPanel.add(new JButton(new CheckOutAction("Check Out", KeyEvent.VK_C)));
        btnPanel.add(new JButton(new CancelAction("Cancel", KeyEvent.VK_N)));
        btnPanel.add(new JButton(new ExitAction("Exit", KeyEvent.VK_X)));

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(selectionPanel);
        add(Box.createVerticalStrut(5)); // so don't crowd things
        add(totalAmountPanel);
        add(Box.createVerticalStrut(5));
        add(btnPanel);
    }

    public void setTotalAmount(double total) {
        totalAmountLabel.setText(formatter.format(total));
    }

    private class AcceptAction extends AbstractAction {

        public AcceptAction(String name, int mnemonic) {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            MyItem myMenuItem = (MyItem) menuCombo.getSelectedItem();
            if (myMenuItem == null) {
                return; // nothing selected, get out
            }
            selectedItems.add(myMenuItem);
            double total = 0.0;
            for (MyItem myItem : selectedItems) {
                total += myItem.getCost();
            }

            setTotalAmount(total);
        }
    }

    private class CheckOutAction extends AbstractAction {
        public CheckOutAction(String name, int mnemonic) {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Finish....
            // open JDialog or JOptionPane

        }
    }

    private class CancelAction extends AbstractAction {
        public CancelAction(String name, int mnemonic) {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Finish...

        }
    }

    private class ExitAction extends AbstractAction {
        public ExitAction(String name, int mnemonic) {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub

        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("My GUI Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Draft2());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
                createAndShowGui();            
        });
    }
}

class MyItem {
    private NumberFormat formatter = NumberFormat.getCurrencyInstance();
    private String name;
    private double cost;
    public MyItem(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return String.format("%-10s %s", name, formatter.format(cost));
    }
}