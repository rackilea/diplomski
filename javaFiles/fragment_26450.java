import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ImagesInResourcesExample {

    private JFrame frame;

    private JPanel buttonsPane;
    private JPanel rightPane;
    private JPanel scorePanel;
    private JPanel colorPanel;

    private BufferedImage img;

    private JButton[][] buttons;

    private JLabel moveLabel;
    private JLabel timeLabel;

    private JButton newGameButton;
    private JButton exitButton;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ImagesInResourcesExample().createAndShowGui();
            }
        });
    }

    @SuppressWarnings("serial")
    public void createAndShowGui() {
        frame = new JFrame(getClass().getSimpleName());
        buttons = new JButton[3][3];
        moveLabel = new JLabel("Move: 0");
        timeLabel = new JLabel("Time: 0");
        colorPanel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(200, 200);
            }
        };
        colorPanel.setBackground(Color.BLUE);
        colorPanel.setOpaque(true);

        newGameButton = new JButton("New Game");
        exitButton = new JButton("Exit");

        try {
            img = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("images/arrow.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        buttonsPane = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(500, 500);
            }
        };
        buttonsPane.setLayout(new GridLayout(3, 3));
        buttonsPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                buttons[i][j] = new JButton(new ImageIcon(img));
                buttonsPane.add(buttons[i][j]);
            }
        }

        rightPane = new JPanel();
        rightPane.setLayout(new GridBagLayout());

        scorePanel = new JPanel();
        scorePanel.setLayout(new GridLayout(1, 2, 10, 10));

        scorePanel.add(moveLabel);
        scorePanel.add(timeLabel);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);

        rightPane.add(scorePanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;

        rightPane.add(colorPanel, gbc);

        gbc.gridy = 2;
        gbc.ipadx = 30;
        gbc.ipady = 80;

        rightPane.add(newGameButton, gbc);

        gbc.gridy = 3;

        rightPane.add(exitButton, gbc);

        rightPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        frame.add(buttonsPane, BorderLayout.CENTER);
        frame.add(rightPane, BorderLayout.EAST);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}