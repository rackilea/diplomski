import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setBackground(Color.BLACK);
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 0.75;
            gbc.weighty = 0.16;
            gbc.gridwidth = 3;
            gbc.insets = new Insets(4, 4, 4, 4);
            add(makePanel(Color.DARK_GRAY), gbc);

            gbc.weightx = 0.25;
            gbc.gridx = 3;
            gbc.gridwidth = 1;
            add(makePanel(Color.ORANGE), gbc);

            gbc.gridy++;
            add(makePanel(Color.DARK_GRAY), gbc);

            gbc.gridx = 0;
            gbc.gridwidth = 3;
            gbc.weightx = 0.75;
            add(makeSmallerPane(), gbc);

            gbc = new GridBagConstraints();
            gbc.weightx = 0.25;
            gbc.insets = new Insets(4, 4, 4, 4);
            gbc.weighty = 0.16;
            gbc.fill = GridBagConstraints.BOTH;
            for (int y = 2; y < 7; y++) {
                gbc.gridx = y;
                for (int x = 0; x < 4; x++) {
                    gbc.gridx = x;
                    Color color = Color.GRAY;
                    if (x == 3) {
                        color = Color.DARK_GRAY;
                    }
                    add(makePanel(color), gbc);
                }
            }
        }

        protected Component makePanel(Color color) {
            JPanel panel = new JPanel();
            panel.setBackground(color);
            return panel;
        }

        protected Component makeSmallerPane() {
            JPanel panel = new JPanel(new GridBagLayout());
            panel.setOpaque(false);
            panel.setLayout(new GridBagLayout());;
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 0.25;
            gbc.weighty = 0.5;
            gbc.insets = new Insets(0, 0, 0, 4);

            int topGap = 0;
            int bottomGap = 4;
            for (int y = 0; y < 2; y++) {
                gbc.gridy = y;
                for (int x = 0; x < 4; x++) {
                    gbc.gridx = x;
                    switch (x) {
                        case 0:
                            gbc.insets = new Insets(topGap, 0, bottomGap, 4);
                            break;
                        case 3:
                            gbc.insets = new Insets(topGap, 4, bottomGap, 0);
                            break;
                        default:
                            gbc.insets = new Insets(topGap, 4, bottomGap, 4);
                            break;
                    }
                    panel.add(makePanel(Color.DARK_GRAY), gbc);
                }
                topGap = 4;
                bottomGap = 0;
            }

            return panel;
        }

    }

}