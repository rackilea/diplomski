import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class game extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public game() {
        nonMaingame canvas = new nonMaingame();
        setSize(1020, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(canvas);

    }

    public static void main(String[] args) {
        new game().setVisible(true);

    }

    public class nonMaingame extends JPanel implements ActionListener {

        /**
         *
         */
        private static final long serialVersionUID = 1L;
        JLabel text;

        public nonMaingame() {
            setLayout(new BorderLayout());

            JPanel canvasSouth = makePanel(Color.RED);
            add(canvasSouth, BorderLayout.SOUTH);

            JPanel canvasNorth = makePanel(Color.BLUE);
            add(canvasNorth, BorderLayout.NORTH);

            JPanel canvasEast = makePanel(Color.YELLOW);
            canvasEast.setBackground(Color.YELLOW);
            add(canvasEast, BorderLayout.EAST);

            JPanel canvasWest = makePanel(Color.MAGENTA);
            add(canvasWest, BorderLayout.WEST);

            text = new JLabel("hey");
            canvasSouth.add(text);
        }

        protected JPanel makePanel(Color color) {
            JPanel pane = new JPanel() {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(100, 100);
                }
            };
            pane.setBackground(color);
            return pane;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub

        }

    }

}