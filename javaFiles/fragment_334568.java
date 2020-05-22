import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Display extends JFrame {

    public Display() {
        super("Mandelbrot Set Display");

        JPanel jp = new JPanel();
        setBounds(0, 0, 800, 600); //800 and 600 not effect because of next line setSize method
        setSize(1000, 1000);// this doesnt resize window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(jp);

    }

    public static void main(String[] args) {
        new Display().setVisible(true);
    }
}