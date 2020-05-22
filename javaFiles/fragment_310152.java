import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel implements ActionListener {

    private GridPane gridPane;

    public Game() {
        setLayout(new BorderLayout());

        SideBarPane sideBar = new SideBarPane();
        sideBar.addActionListener(this);
        add(sideBar, BorderLayout.WEST);

        gridPane = new GridPane();
        add(gridPane);
    }

    public static void main(String args[]) {
        Game game = new Game();

        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setTitle("Game");
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());
        frame.add(game);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("grid")) {
            gridPane.setGridOn(!gridPane.isGridOn());
        }
    }

    public class GridPane extends JPanel {

        private boolean gridOn = false;

        public GridPane() {
            setBackground(Color.BLACK);
        }

        public boolean isGridOn() {
            return gridOn;
        }

        public void setGridOn(boolean value) {
            if (value != gridOn) {
                this.gridOn = value;
                repaint();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (gridOn) {
                g.setColor(Color.white);
                g.drawLine(0, 0, 50, 300);
            }
        }
    }

    public class SideBarPane extends JPanel {

        public JButton grid;

        public SideBarPane() {
            setBackground(new Color(255, 0, 50));
            setLayout(new GridBagLayout());
            grid = new JButton("Show Grid");
            grid.setActionCommand("grid");
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.weighty = 1;
            add(grid, gbc);
        }

        public void addActionListener(ActionListener listener) {
            grid.addActionListener(listener);
        }
    }
}