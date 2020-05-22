import javax.swing.JFrame;

public class MvcFrame extends JFrame {
    private final Model model;

    public MvcFrame(Model model){
        this.model = model;
        // Anytime you add anything to a JFrame, use the content pane.
        this.getContentPane().add(model.getView());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // This line centers the frame on your screen.
        setLocationRelativeTo(null);
        setSize(800,600);
        // The frame won't paint until it's visible.
        // This means if you check dimensions, everything will be 0 x 0
        // until this line is called.
        setVisible(true);
    }
}