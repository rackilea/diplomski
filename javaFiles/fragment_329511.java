import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
    private static CardLayout cards;
    private static JPanel panel;

    private Main() {
        super("Card Layout");
        setBounds(0, 0, 500, 500);
        setDefaultCloseOperation(3);

        panel = new JPanel();
        cards = new CardLayout();
        panel.setLayout(cards);

        JPanel p1 = new JPanel();
        p1.setBackground(Color.WHITE);

        JPanel p2 = new JPanel();
        p2.setBackground(Color.BLACK);

        JPanel p3 = new JPanel();
        p3.setBackground(Color.RED);

        JPanel p4 = new JPanel();
        p4.setBackground(Color.BLUE);

        panel.add(p1, "white");
        panel.add(p2, "black");
        panel.add(p3, "red");
        panel.add(p4, "blue");

        // cards.next(panel); This works fine for me.
        cards.show(panel, "red");
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}