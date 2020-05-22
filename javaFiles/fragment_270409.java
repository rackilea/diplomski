public class MyFrame extends JFrame {

    public MyFrame() {
        JPanel panel = new MyPanel();
        add(panel);
        pack();
        setVisible(true);
    }
}