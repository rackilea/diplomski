import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ChessFrame extends JFrame {

    private JPanel panel;
    private JLabel greyBox;
    private JLabel pawn;


    public ChessFrame() {
        super();

        /* configure the JFrame */
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void addComponents() {
        panel = new JPanel();
        greyBox = new JLabel(new ImageIcon("images/grey.jpg"));
        pawn = new JLabel(new ImageIcon("images/pawn.png"));

        /* add the pawn inside the grey box (we have to set a layout for the grey box JLabel) */
        greyBox.setLayout(new BorderLayout());
        greyBox.add(pawn);

        /* add grey box to main JPanel and set its background to white so we observe the result better */
        panel.add(greyBox);
        panel.setBackground(Color.WHITE);

        this.getContentPane().add(panel);
    }


    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
    }

}