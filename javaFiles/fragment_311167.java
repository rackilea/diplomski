public class Scratch extends JPanel {

    static int frameWidth = 700;
    static int frameHeight = 700;

    public static void main(String[] args) {

    JFrame frame = new JFrame();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Scratch scratch = new Scratch();
    scratch.setSize(frameWidth, frameHeight);

    frame.getContentPane().add(scratch);

    frame.pack();
    frame.setVisible(true);

    }