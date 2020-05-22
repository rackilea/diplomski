import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Test {

    private static final int N = 8;
    private JFrame frame = new JFrame();
    private TestPanel[][] square = new TestPanel[N][N];
    private TestButton[][] button = new TestButton[N][N];

    public Test() {
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(N, N));
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                TestPanel tp = new TestPanel(x, y);
                square[x][y] = tp;
                button[x][y] = tp.getButton();
                gridPanel.add(tp);
            }
        }
        frame.add(gridPanel);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JButton(new AbstractAction("New") {
            @Override
            public void actionPerformed(ActionEvent e) {
                button[2][2].newGame();
                square[3][3].setBackground(Color.magenta);
                button[4][4].parent.setBackground(Color.yellow);
            }
        }));
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private static class TestPanel extends JPanel {

        private static final int SIZE = 48;
        private TestButton button;

        public TestButton getButton() {
            return button;
        }

        public TestPanel(int x, int y) {
            super(new GridLayout(1, 1));
            this.button = new TestButton(this, x, y);
            this.add(button);
            if ((x + y) % 2 == 0) {
                this.setBackground(Color.cyan);
            } else {
                this.setBackground(Color.blue);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(SIZE, SIZE);
        }
    }

    private static class TestButton extends JButton {

        private TestPanel parent;
        private int gridX, gridY;

        public TestButton(final TestPanel parent, int x, int y) {
            this.parent = parent;
            this.gridX = x;
            this.gridY = y;
            this.setOpaque(false);
            this.setContentAreaFilled(false);
            this.setBorderPainted(false);
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    TestButton clicked = (TestButton) e.getSource();
                    parent.setBackground(Color.green);
                    int x = clicked.getGridX();
                    int y = clicked.getGridY();
                    System.out.println(x + " : " + y);
                }
            });
        }

        public int getGridX() {
            return gridX;
        }

        public int getGridY() {
            return gridY;
        }

        public void newGame() {
            parent.setBackground(Color.red);
        }
    }

    public static void main(String[] args) {
        new Test();
    }
}