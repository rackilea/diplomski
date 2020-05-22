import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Squares {

    public static void main(String[] args) {
        new Squares();
    }

    public Squares() {
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

        private int runningTime = 5000;
        private long cycleStartedAt = -1;
        private double progress = 0;

        private double[][] squares = {
            {0, 0.30},
            {0.075, 0.375},
            {0.15, 0.45},
            {0.225, 0.525},
            {0.30, 0.60},

            {0.30, 0.675},
            {0.375, 0.75},
            {0.45, 0.825},
            {0.525, 0.90},
            {0.6, 0.975},
        };

        public TestPane() {
            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (cycleStartedAt == -1) {
                        cycleStartedAt = System.currentTimeMillis();
                    }
                    long duration = System.currentTimeMillis() - cycleStartedAt;
                    progress = (double)duration / (double)runningTime;
                    if (progress > 1.0d) {
                        cycleStartedAt = -1;
                        progress = 0;
                    }
                    repaint();
                }
            });
            timer.setRepeats(true);
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics g2d = (Graphics2D) g.create();
            int width = getWidth() - 1;
            int height = getHeight() - 1;

            int hGap = width / squares.length;
            int vGap = height / squares.length;

            int index = 0;
            for (double[] square : squares) {                
                if (progress >= square[0] && progress <= square[1]) {                    
                    int sWidth = hGap * (index + 1);
                    int sHeight = vGap * (index + 1);
                    int x = (width - sWidth) / 2;
                    int y = (height - sHeight) / 2;
                    g2d.drawRect(x, y, sWidth, sHeight);

                }
                index++;                
            }            
            g2d.dispose();
        }        
    }    
}