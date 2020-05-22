public class ExampleFrame extends JFrame {

    public ExampleFrame() {
        MyPanel panel = new MyPanel();
        getContentPane().add(panel);

        setTitle("My Cool Custom Panel");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ExampleFrame().setVisible(true);
    }
}