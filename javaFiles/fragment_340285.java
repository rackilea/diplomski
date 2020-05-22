import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sudoku extends JFrame {

    public Sudoku(){

        //Initialise the window and show it
        this.setTitle("Sudoku Solver");
        this.setSize(1000, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel board = new JPanel();
        board.setLayout(new GridLayout(3,3));

        //Initialise an array of JPanel
        JPanel[][] panels = new JPanel[3][3];
        for (int r = 0; r < 3; r++)
        {
            for (int c = 0; c < 3; c++)
            {
                JPanel panel = new JPanel( new GridLayout(3, 3) );
                panels[r][c] = panel;
                board.add( panel );
            }
        }

        //Initialise the JButtons
        JButton[][] buttons = new JButton[9][9];
        for(int r = 0; r < 9; r++)
        {
            for(int c = 0; c < 9; c++)
            {
                buttons[r][c] = new JButton(r + "/" + c);
            }
        }

        for (int panelR = 0; panelR < 3; panelR++)
        {
            for (int panelC = 0; panelC < 3; panelC++)
            {
                int buttonR = panelR * 3;
                int buttonC = panelC * 3;

                for (int i = 0; i < 9; i++)
                {
                    panels[panelR][panelC].add(buttons[buttonR][buttonC]);
                    buttonC++;

                    if ((i + 1) % 3 == 0)
                    {
                        buttonC = panelC * 3;
                        buttonR++;
                    }
                }
            }
        }

        this.setContentPane(board);
        this.setVisible(true);

    }

    public static void main(String[] args) throws Exception
    {
        java.awt.EventQueue.invokeLater( () -> new Sudoku() );
    }
}