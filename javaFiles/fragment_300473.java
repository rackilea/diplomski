import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Start {
    public static void main(String[] args) {
        StartScreen startFrame = new StartScreen();
    }
}

class StartScreen extends JFrame {
    // Constructor
    public StartScreen() {
        // Fonts
        Font snakeTitleFont = new Font("Arial", Font.BOLD, 50);
        Font buttonFont = new Font("Arial", Font.CENTER_BASELINE, 20);

        // Text
        JLabel snakeTitle = new JLabel("Snake", SwingConstants.CENTER);
        snakeTitle.setFont(snakeTitleFont);
        add(snakeTitle, BorderLayout.NORTH);

        // Start button
        JButton startButton = new JButton("Start");
        startButton.setBackground(Color.MAGENTA);
        startButton.setOpaque(true);
        startButton.setBorderPainted(false);
        startButton.setFont(buttonFont);

        // ActionListener for Start button
        startButton.addActionListener(new ActionListener() {
            // once this is clicked on, it should call the GUI
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame();
                // closes the old form after start is clicked
                dispose();
            }
        });

        // Back button
        JButton backButton = new JButton("Back");
        backButton.setLayout(null);
        backButton.setBackground(Color.YELLOW);
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);
        backButton.setFont(buttonFont);

        // Panel for Start and Back buttons
        JPanel panel = new JPanel();
        panel.add(startButton);
        panel.add(backButton);
        add(panel, BorderLayout.CENTER);

        this.setVisible(true);
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
}