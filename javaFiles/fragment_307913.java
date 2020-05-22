import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

@SuppressWarnings("serial")
public class InputForm2 extends JPanel {
    private static final int COLS = 10;
    private List<ShoppingItem> shoppingList = new ArrayList<>();
    private JTextField nameField = new JTextField(COLS);
    private JTextField skuField = new JTextField(COLS);
    private JTextField priceField = new JTextField(COLS);    

    public InputForm2() {
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.add(new JLabel("Item Name:"), createGbc(0, 0));
        formPanel.add(nameField, createGbc(1, 0));
        formPanel.add(new JLabel("Item SKU:"), createGbc(0, 1));
        formPanel.add(skuField, createGbc(1, 1));
        formPanel.add(new JLabel("Price:"), createGbc(0, 2));
        formPanel.add(priceField, createGbc(1, 2));

        JPanel btnPanel = new JPanel(new GridLayout(1, 0, 4, 4));
        btnPanel.add(new JButton(new AddItemAction("Add Item")));
        btnPanel.add(new JButton(new DisplayItemsAction("Display Items")));

        setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        setLayout(new BorderLayout());
        add(formPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.PAGE_END);
    }

    private static GridBagConstraints createGbc(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = x == 0 ? GridBagConstraints.WEST : GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        int inset = 4;
        int leftInset = x == 0 ? inset : 3 * inset;
        gbc.insets = new Insets(inset, leftInset, inset, inset);
        return gbc;
    }

    private class AddItemAction extends AbstractAction {
        public AddItemAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0); // mnemonic keystroke
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO finish this
            // get Strings from fields
            // create ShoppingItem object
            // add to shoppingList

        }
    }

    private class DisplayItemsAction extends AbstractAction {
        public DisplayItemsAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0); // mnemonic keystroke
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO finish this

        }
    }

    private static void createAndShowGui() {
        InputForm2 mainPanel = new InputForm2();

        JFrame frame = new JFrame("InputForm2");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}

class ShoppingItem {
    private String name;
    private String skuNumber;
    private double price;
    public ShoppingItem(String name, String skuNumber, double price) {
        this.name = name;
        this.skuNumber = skuNumber;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public String getSkuNumber() {
        return skuNumber;
    }
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("name: %s, sku: %s, price: $%0.df", name, skuNumber, price);        
    }
}