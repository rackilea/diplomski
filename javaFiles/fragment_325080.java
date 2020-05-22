import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.*;

public class GameFrame extends JFrame {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new GameFrame();
                    frame.setContentPane(new JLabel(new ImageIcon(getClass()
                            .getResource("/image/675 x 588 Connect Four.png"))));
                    frame.addSlots();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */

    static GameFrame frame;
    private static Icon slotForButton;
    public static JButton slotButton;
    static private JButton[] slot = new JButton[42];
    static private String[] slotColor = new String[42];
    static boolean turn = true;
    static boolean legitClick;
    static String slotClicked;
    static int slotNum;
    static Container gamePane;

    public GameFrame() {
        setBounds(100, 100, 685, 622);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        super.setTitle("Connect Four by Joel Christophel");
    }

    void addSlots() {
        ButtonHandler bh = new ButtonHandler();
        gamePane = getContentPane();
        gamePane.setLayout(new GridLayout(6, 6));

        for (int counter = 0; counter < slot.length; counter++) {
            // Added by me.
            slot[counter] = new JButton();
            slot[counter].setIcon(makeSlot("white", counter));
            slot[counter].setBorderPainted(false);
            slot[counter].setContentAreaFilled(false);
            slot[counter].setFocusPainted(false);
            slot[counter].setActionCommand(counter + "");
            slotColor[counter] = "white";

            slot[counter].addActionListener(bh);
            add(slot[counter]);

            //counter++;
        }
    }

    static Icon makeSlot(String color, int index) {

        if (color.equals("white")) {
            slotForButton = new ImageIcon(
                    GameFrame.class.getResource("/image/Space.png"));
        }

        else if (color.equals("red")) {
            slotForButton = new ImageIcon(
                    GameFrame.class.getResource("/image/Red Checker.png"));
        }

        else if (color.equals("black")) {
            slotForButton = new ImageIcon(
                    GameFrame.class.getResource("/image/Black Checker.png"));
        }

        //slot[index].setIcon(slotForButton);

        return slotForButton;
    }

    private class ButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            slotClicked = e.getActionCommand();

            GameFrame.legitClick(slotClicked);
        }

    }

    private static void changeTurn() {
        turn = !turn; // true is red's turn; false is black's
    }

    private static void legitClick(String slotClicked1) {
        legitClick = false;

        slotClicked = slotClicked1;
        Scanner numScan = new Scanner(slotClicked);
        slotNum = numScan.nextInt();

        try {
            if (slotColor[slotNum + 7].equals("white")&&slotColor[slotNum].equals("white")) {
                legitClick = true;
            }
        }

        catch (ArrayIndexOutOfBoundsException t) {

            if (slotColor[slotNum].equals("white")) {
                legitClick = true;
            }
        }

        /*
         * This variable is used to tell
         * makeSlot that the JButton at
         * this index is pressed. So
         * simply change the Icon for this
         * JButton, instead of adding a new 
         * JButton.
         */
        int index = Integer.parseInt(slotClicked1);

        if (legitClick == true) {
            if (turn == true) {
                slot[index].setIcon(makeSlot("red", index));
                slotColor[slotNum] = "red";
                System.out.println("Put " + slotColor[slotNum] + " checker     in slot number " + slotNum + ".");
            }

            else if (turn == false) {
                slot[index].setIcon(makeSlot("black", index));
                slotColor[slotNum] = "black";
                System.out.println("Put " + slotColor[slotNum] + " checker      in slot number " + slotNum + ".");
            }

            //gamePane.validate();
            GameFrame.changeTurn();
        }
        System.out.println(turn);
    }

}