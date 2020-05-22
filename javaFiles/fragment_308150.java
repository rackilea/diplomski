import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ShuffleButtons {

    private JButton[] buttons;
    private JPanel gridPanel;

    public ShuffleButtons() {
        gridPanel = new JPanel(new GridLayout(4, 4));
        buttons = getButtons(16);
        layoutButtons();

        JFrame frame = new JFrame("Shuffle Buttons");
        frame.add(gridPanel);
        frame.add(getResetButton(), BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void shuffleButtons() {
        if (buttons != null) {
            Collections.shuffle(Arrays.asList(buttons));
            layoutButtons();
        }
    }

    public void layoutButtons() {
        gridPanel.removeAll();
        for (JButton button : buttons) {
            gridPanel.add(button);
        }
        gridPanel.revalidate();
        gridPanel.repaint();
    }

    private JButton[] getButtons(int size) {
        JButton[] buttons = new JButton[size];
        for (int i = 0; i < size; i++) {
            final JButton button = new JButton(" [ " + i + " ] ");
            button.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Button " + button.getText() + " pressed");
                }
            });
            buttons[i] = button;
        }
        return buttons;
    }

    private JButton getResetButton() {
        JButton button = new JButton("RESET");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                shuffleButtons();
            }
        });
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new ShuffleButtons();
            }
        });
    }
}