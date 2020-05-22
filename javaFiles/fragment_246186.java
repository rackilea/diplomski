import javax.swing.JFrame;

public class SimpleGUITest {
    public static void main(String[] args) {
        SimpleGUI frame = new SimpleGUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}