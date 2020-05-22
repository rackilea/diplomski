import javax.swing.*;

public class BluetoothButton {
    public static void main(String[] arguments) {
        SwingUtilities.invokeLater(() -> new BluetoothButton().createAndShowGui());
    }

    private void createAndShowGui() {
        JFrame frame = new JFrame("Stack Overflow");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton button = new JButton("Search for services");

        button.addActionListener(actionEvent -> {
            MyDiscoveryListener listener =  new MyDiscoveryListener();
            listener.searchForServices();
        });

        frame.getContentPane().add(button);

        frame.setVisible(true);
    }
}