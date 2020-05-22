import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Scrollable;

@SuppressWarnings("serial")
public class DrawPanel extends JPanel implements Scrollable {
    public static final int VISIBLE_ROW_COUNT = 8;
    private static final int ROW_COUNT = 12;
    private static final Color DARK_COLOR = Color.DARK_GRAY;
    private static final Color LIGHT_COLOR = Color.WHITE;
    private int cellWidth;

    public DrawPanel(int cellWidth) {
        super(new GridLayout(ROW_COUNT, ROW_COUNT));
        this.cellWidth = cellWidth;
        Dimension prefSize = new Dimension(cellWidth, cellWidth);
        for (int i = 0; i < ROW_COUNT; i++) {
            for (int j = 0; j < ROW_COUNT; j++) {
                JPanel cell = new JPanel();
                cell.setPreferredSize(prefSize);
                Color c = i % 2 == j % 2 ? DARK_COLOR : LIGHT_COLOR;
                cell.setBackground(c);
                add(cell);

                // TODO: delete the code below. For demo/debug purposes only
                String text = String.format("[%d, %d]", j, i);
                JLabel label = new JLabel(text);
                c = c == DARK_COLOR ? LIGHT_COLOR : DARK_COLOR;
                label.setForeground(c);
                cell.add(label);
                // TODO: end delete block
            }
        }
    }

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        Dimension viewportSize = new Dimension(VISIBLE_ROW_COUNT * cellWidth, VISIBLE_ROW_COUNT * cellWidth);
        return viewportSize;
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation,
            int direction) {
        return cellWidth;
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        return false;
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return false;
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation,
            int direction) {
        return 1;
    }

    // note that getPreferredSize already returns the size of the 12 x 12 grid
    // since it is composed of a grid sized JPanels

}