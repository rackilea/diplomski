import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JframeExample extends JFrame {

    private final JPanel P1;
    private final JPanel P2;
    private final JPanel main;
    private final JScrollPane scrol;
    private final JButton jButton;
    private final JButton jButton2;

    public JframeExample() {
        P1 = new JPanel();
        P2 = new JPanel();
        main = new JPanel();
        jButton = new JButton("Add");
        jButton2 = new JButton("Remove");
        scrol = new JScrollPane(P2);
        initialize();
        this.add(main);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        JframeExample jframeExample = new JframeExample();

    }

    private void addPressed(ActionEvent evt) {
        System.out.println("Add Pressed");
        P2.add(new JButton());
        revalidate();
    }

    private void removePressed(ActionEvent evt) {
        System.out.println("Remove Pressed");
        P2.removeAll();
        revalidate();
    }

    private void initialize() {
        main.setLayout(new GridLayout(1, 2));
        main.add(P1);
        main.add(scrol);
        jButton.addActionListener((ActionEvent evt) -> {
            addPressed(evt);
        });
        jButton2.addActionListener((ActionEvent evt) -> {
            removePressed(evt);
        });
        P1.add(jButton);
        P1.add(jButton2);
    }

}