public class GUIExample extends JFrame {

    JCheckBox box1 = new JCheckBox("Satellite Radio");

    public static void main(String[] args) {
        JFrame frame = new GUIExample("GUI Example");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(box1);

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}