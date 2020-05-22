import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class LineDrawer {
    private JFrame frame;
    private JButton button;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new LineDrawer()::createAndShowGui); //Put our program on the EDT
    }

    private void createAndShowGui() {
        frame = new JFrame(getClass().getSimpleName());

        MyPane pane = new MyPane(); //Create an instance of our custom JPanel class
        button = new JButton("Hide/Show");

        button.addActionListener(e -> {
            pane.setShowLine(!pane.isShowLine()); //Change the state of the flag to its inverse: true -> false / false -> true
        });

        frame.add(pane);
        frame.add(button, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //Our custom class that handles painting.
    @SuppressWarnings("serial")
    class MyPane extends JPanel {
        private boolean showLine;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            if (showLine) { //If true, show line
                g2d.draw(new Line2D.Double(50, 50, 100, 50));
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300); //For the size of our JPanel
        }

        public boolean isShowLine() {
            return showLine;
        }

        public void setShowLine(boolean showLine) {
            this.showLine = showLine;
            this.repaint(); //Everytime we set a new state to showLine, repaint to make the changes visible
        }
    }
}