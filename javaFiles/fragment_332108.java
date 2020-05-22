import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PurchaseStock  extends JFrame implements ActionListener {
    private JPanel top = new JPanel();
    private JPanel middle = new JPanel();
    StockData sD;

    PurchaseStock () {
        super("Fist Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add("North", top);
        add("Center", middle);

        top.add(new StockDropdown(this));

        pack();
        setVisible(true);
    }

    public JPanel getMiddle() {
        return middle;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PurchaseStock  frame = new PurchaseStock();
            }
        });
    }
}