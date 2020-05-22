import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(true);
        JOptionPane.showMessageDialog(
            frame, "test info", "test header", JOptionPane.INFORMATION_MESSAGE);
        // When a frame is disposed, the exit action will be called.
        frame.dispose();
    }
}