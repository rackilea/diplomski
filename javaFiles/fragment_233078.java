// Main class.
public class FrameTestBase extends JFrame {

    public static void main(String args[]) {

        // Create the "model".
        final MovableImage mi = new MovableImage();

        FrameTestBase t = new FrameTestBase();
        t.setLayout(new BorderLayout());

        // Add a component presenting the model.
        t.add(new ImgComponent(mi), BorderLayout.CENTER);

        // Create a button which increments x when clicked on.
        t.add(new JButton(new AbstractAction("Move right") {
            @Override
            public void actionPerformed(ActionEvent e) {
                mi.incrementX();
            }
        }), BorderLayout.SOUTH);

        // Show it.
        t.setDefaultCloseOperation(EXIT_ON_CLOSE);
        t.setSize(400, 400);
        t.setVisible(true);
    }
}