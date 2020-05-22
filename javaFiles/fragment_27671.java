package so;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater( () -> {

            JFrame frame = new JFrame("Label test");

            JPanel helperPanel = new JPanel();

            frame.setContentPane(helperPanel);
            helperPanel.setLayout(new BorderLayout());

            JLabel buffSlot_6 = new JLabel();
            buffSlot_6.setBorder(new LineBorder(Color.BLACK));
            buffSlot_6.setHorizontalAlignment(SwingConstants.RIGHT);
            buffSlot_6.setVerticalAlignment(SwingConstants.BOTTOM);
            buffSlot_6.setText("2");

            buffSlot_6.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
            helperPanel.add(buffSlot_6, BorderLayout.CENTER);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setSize(100, 100);
            frame.setVisible(true);

        } );
    }
}