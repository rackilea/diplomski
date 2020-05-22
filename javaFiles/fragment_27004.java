import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.Window;
import javax.swing.*;

public class InventoryFoo extends JPanel {
    private static final Car FIRST_CAR = new Car("Honda");
    private InventoryItemPanel inventoryItemPanel = new InventoryItemPanel(FIRST_CAR);

    public InventoryFoo() {

        inventoryItemPanel.setBorder(BorderFactory.createTitledBorder("Inventory Item"));

        add(inventoryItemPanel);
    }

    private static void createAndShowGui() {
        InventoryFoo mainPanel = new InventoryFoo();

        JFrame frame = new JFrame("InventoryFoo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}