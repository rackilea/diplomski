import java.awt.BorderLayout;
import java.awt.Point;

import javax.swing.*;

@SuppressWarnings("serial")
public class FrameAGrid extends JPanel {
    private static final int CELL_WIDTH = 80;
    private DrawPanel drawPanel = new DrawPanel(CELL_WIDTH);
    private JScrollPane drawPanelScrollPane = new JScrollPane(drawPanel); 

    public FrameAGrid() {
        drawPanelScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        drawPanelScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        setLayout(new BorderLayout());
        add(drawPanelScrollPane);

        int x = 2 * CELL_WIDTH;
        int y = x;
        Point pt = new Point(x, y);
        drawPanelScrollPane.getViewport().setViewPosition(pt);
    }


    private static void createAndShowGui() {
        FrameAGrid mainPanel = new FrameAGrid();

        JFrame frame = new JFrame("FrameAGrid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}