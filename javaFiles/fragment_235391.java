import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class BattleshipFinal {

    public static void main(final String[] args) {

        GameBoard gb = new GameBoard();
        JFrame frame = new JFrame("Battleship - Server");
        JComponent board = gb.getGui();
        frame.add(board);
        frame.setLocationByPlatform(true);
        //frame.setMinimumSize(frame.getSize());
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        //frame.setPreferredSize(new Dimension(100, 100));
        board.setMinimumSize(new Dimension(100, 100));
        board.setPreferredSize(new Dimension(100, 100));
        frame.setMinimumSize(new Dimension(100, 100));
        frame.setLocation(50, 50);
        frame.pack();
        frame.setVisible(true);

    }

}