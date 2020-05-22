import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class GridLayoutEg extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final int ROWS = 3;
    private static final int COLS = 10;

    public GridLayoutEg() {
        int gap = 1;
        int gap2 = 2;
        setBorder(BorderFactory.createEmptyBorder(gap2, gap2, gap2, gap2));
        setLayout(new GridLayout(ROWS, COLS, gap, gap)); // set JPanel's layout
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                JButton button = createSeat(row, col);
                add(button); // add component w/o a 2nd parameter
            }
        }
    }

    private JButton createSeat(int row, int col) {
        SeatColor seatColor = SeatColor.values()[row];
        SeatAction seatAction = new SeatAction(seatColor, col);
        JButton button = new JButton(seatAction);
        button.setBackground(seatColor.getColor());
        int topGap = 8;
        int sideGap = 25;
        Border innerBorder = BorderFactory.createEmptyBorder(topGap, sideGap, topGap, sideGap);
        Border outerBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED, seatColor.getColor().brighter(),
                seatColor.getColor().darker());
        Border border = BorderFactory.createCompoundBorder(outerBorder, innerBorder);
        button.setBorder(border);
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui() {
        GridLayoutEg mainPanel = new GridLayoutEg();
        JFrame frame = new JFrame("GridLayoutEg");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}

class SeatAction extends AbstractAction {
    private static final long serialVersionUID = 1L;
    private SeatColor seatColor;
    private int column;

    public SeatAction(SeatColor seatColor, int column) {
        super(String.format("[%d]", column));
        this.seatColor = seatColor;
        this.column = column;
        // putValue(LARGE_ICON_KEY, createIcon(seatColor, column));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractButton btn = (AbstractButton) e.getSource();
        btn.setBackground(seatColor.getColor().brighter());
        setEnabled(false);

        String text = String.format("Selected Seat Color: %s; Column: %d", seatColor, column);
        System.out.println(text );
    }
}

enum SeatColor {
    GOLD("Gold", new Color(255, 215, 0)), 
    SILVER("Silver", new Color(192, 192, 192)), 
    BRONZE("Bronze", new Color(205, 127, 50));

    private String text;
    private Color color;

    private SeatColor(String text, Color color) {
        this.text = text;
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return getText();
    }

}