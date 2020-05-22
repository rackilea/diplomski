import javax.swing.JFrame;
import javax.swing.JLabel;

public class prueba extends JFrame {
    private static final long serialVersionUID = 1L;

    public prueba() {
        add(new JLabel("Intenteu tancar per la creueta..."));
        setTitle("Primer JFrame");
        setSize(800,600);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        new prueba();
     }
 }