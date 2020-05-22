import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JButtonHighlighter extends JPanel {

    public static void main(final String[] args) {

        JFrame frame = new JFrame();

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(10, 10));

        JButton[][] buttonArray = new JButton[10][10];

        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {

                final JButton newButton = new JButton();

                final Color originalColor = newButton.getBackground();
                final Color highlightColor = Color.GREEN;

                newButton.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseEntered(final MouseEvent e) {
                        newButton.setBackground(highlightColor);

                    }

                    @Override
                    public void mouseExited(final MouseEvent e) {
                        newButton.setBackground(originalColor);

                    }

                });

                buttonArray[r][c] = newButton;

                contentPanel.add(newButton);
            }
        }

        frame.setContentPane(contentPanel);
        frame.setSize(100, 100);
        frame.setVisible(true);

    }

}