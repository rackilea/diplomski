import javax.swing.*;

public class Agui extends JFrame {

    public Agui() {

        setTitle("My Gui");
        setSize(400, 400);

        // Create JButton and JPanel
        JButton button = new JButton("Click here!");
        JPanel panel = new JPanel();

        // Add button to JPanel
        panel.add(button);
        // And JPanel needs to be added to the JFrame itself!
        this.getContentPane().add(panel);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        Agui a = new Agui();
    }
}