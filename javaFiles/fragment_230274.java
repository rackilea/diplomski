import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Tictactoe extends JFrame {

//construct a figurePanel
public Tictactoe(String text) {

    Container RandomTicTacToePanel = getContentPane();
    RandomTicTacToePanel.setLayout(new GridLayout(3, 3));


    for (int i = 0; i < 9; i++) {
        RandomTicTacToePanel.add(new drawOnGrid(text));
    }
}

//Main method
public static void main(String[] args) {

    String argOne = null; // Init with null
    String argTwo = null; // Init with null

    Scanner in = new Scanner(System.in);

    int length = args.length;
    if (length <= 0) {
        System.out.println("Please enter player One's symbol: ");
        argOne = in.nextLine();
        System.out.println("Please enter player Two's symbol: ");
        argTwo = in.nextLine();
        in.close();
    } else if(length == 1) {
        argOne = args[0];
    } else if(length == 2) {
        argOne = args[0];
        argTwo = args[1];
    }

    Tictactoe Tframe = new Tictactoe(argOne);
    Tframe.setTitle("Tic Tac Toe Panel: Random Entries");
    Tframe.setSize(350, 350);
    Tframe.setResizable(true);
    Tframe.setLocationRelativeTo(null);
    Tframe.setVisible(true);
    Tframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

class drawOnGrid extends JPanel {

    private String text;

    public drawOnGrid(String text) {
       this.text = text;
    }

    //overide the paintComponent
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int random = (int) (Math.random() * 3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (random == 0) {
                    System.out.print(" ");
                } else if (random == 1) {
                    g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
                } else if (random == 2) {
                    g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
                    g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);

                }
            }

        }
    }
}