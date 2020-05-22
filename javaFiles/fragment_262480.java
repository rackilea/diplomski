import java.awt.*;
import javax.swing.*;

public class MakingLayout extends JFrame
{
    public MakingLayout()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        JPanel leftPanel = new JPanel();
        JLabel leftLabel = new JLabel("Output : ", JLabel.CENTER);

        leftPanel.add(leftLabel);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JLabel centerFirstLabel = new JLabel("Google Inc.", JLabel.LEFT);
        JLabel centerSecondLabel = new JLabel("Price : 618.405", JLabel.LEFT);
        JLabel centerThirdLabel = new JLabel("<html>Change : <font color = red>-4.06 (-0.65%)</font> </html>", JLabel.LEFT);
        JLabel centerFourthLabel = new JLabel("Divident : 0.00", JLabel.LEFT);
        JLabel centerFifthLabel = new JLabel("Market Cap : 200.38", JLabel.LEFT);
        JLabel centerSixthLabel = new JLabel("Stock Exchange : NasdaqNM", JLabel.LEFT);

        centerPanel.add(centerFirstLabel);
        centerPanel.add(centerSecondLabel);
        centerPanel.add(centerThirdLabel);
        centerPanel.add(centerFourthLabel);
        centerPanel.add(centerFifthLabel);
        centerPanel.add(centerSixthLabel);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.PAGE_START;
        JLabel bottomLabel = new JLabel(" Input : ", JLabel.LEFT);

        JPanel digitPanel = new JPanel();
        JButton[] button = new JButton[10];
        for (int i = 0; i < 10; i++)
        {
            button[i] = new JButton("" + i);
            digitPanel.add(button[i]);
        }

        JPanel topLinePanel = new JPanel();
        JButton[] buttonTop = new JButton[11];
        buttonTop[0] = new JButton("Q");
        buttonTop[1] = new JButton("W");
        buttonTop[2] = new JButton("E");
        buttonTop[3] = new JButton("R");
        buttonTop[4] = new JButton("T");
        buttonTop[5] = new JButton("Y");
        buttonTop[6] = new JButton("U");
        buttonTop[7] = new JButton("I");
        buttonTop[8] = new JButton("O");
        buttonTop[9] = new JButton("P");
        buttonTop[10] = new JButton("DEL");
        for (int i = 0; i < 11; i++)
        {
            topLinePanel.add(buttonTop[i]);
        }

        JPanel middleLinePanel = new JPanel();
        JButton[] buttonMiddle = new JButton[10];
        buttonMiddle[0] = new JButton("A");
        buttonMiddle[1] = new JButton("S");
        buttonMiddle[2] = new JButton("D");
        buttonMiddle[3] = new JButton("F");
        buttonMiddle[4] = new JButton("G");
        buttonMiddle[5] = new JButton("H");
        buttonMiddle[6] = new JButton("J");
        buttonMiddle[7] = new JButton("K");
        buttonMiddle[8] = new JButton("L");
        buttonMiddle[9] = new JButton("RET");
        for (int i = 0; i < 10; i++)
        {
            middleLinePanel.add(buttonMiddle[i]);
        }

        JPanel bottomLinePanel = new JPanel();
        JButton[] buttonBottom = new JButton[8];
        buttonBottom[0] = new JButton("Z");
        buttonBottom[1] = new JButton("X");
        buttonBottom[2] = new JButton("C");
        buttonBottom[3] = new JButton("V");
        buttonBottom[4] = new JButton("B");
        buttonBottom[5] = new JButton("N");
        buttonBottom[6] = new JButton("M");
        buttonBottom[7] = new JButton(".");
        for (int i = 0; i < 8; i++)
        {
            bottomLinePanel.add(buttonBottom[i]);
        }

        bottomPanel.add(bottomLabel, gbc);
        gbc.gridy = 1;
        bottomPanel.add(digitPanel, gbc);
        gbc.gridy = 2;
        bottomPanel.add(topLinePanel, gbc);
        gbc.gridy = 3;
        bottomPanel.add(middleLinePanel, gbc);
        gbc.gridy = 4;
        bottomPanel.add(bottomLinePanel, gbc);

        contentPane.add(leftPanel, BorderLayout.WEST);
        contentPane.add(centerPanel, BorderLayout.CENTER);
        contentPane.add(bottomPanel, BorderLayout.PAGE_END);

        setContentPane(contentPane);
        pack();
        setVisible(true);       
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new MakingLayout();
            }
        });
    }
}