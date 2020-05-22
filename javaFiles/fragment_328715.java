import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


//make it a sub class of JFrame for easier implementation.
public class Board extends JFrame{

    private static final int COLUMNS_NUM = 3;
    private static final int ROWS_NUM = 3;

    Cell cells[] = new Cell[COLUMNS_NUM * ROWS_NUM];

    public Board(){

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 800));

        JPanel panel = new JPanel();
        add(panel);  //or better    getContentPane().add(panel);
        panel.setLayout(new GridLayout(ROWS_NUM, COLUMNS_NUM));

        for (int i = 0; i <(ROWS_NUM * COLUMNS_NUM); i++)
        {
            cells[i] = new Cell();
            panel.add(cells[i]);
        }

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Board();
    }
}