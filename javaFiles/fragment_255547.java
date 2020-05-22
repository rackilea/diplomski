class MouseAdapterMod extends MouseAdapter {
/*Set 'X' or 'O' based the selected radio button- how to achieve this? */

    JRadioButton xButton;

    public MouseAdapterMod(JRadioButton xButton)
    {
        this.xButton = xButton;
    }

    public void mousePressed(MouseEvent e) {
     JButton button = (JButton)e.getSource();

     if(xButton.isSelected())
     button.setText("X");
     else
     button.setText("O");    
    }
}

/**
*
* @author saikrishnan.srivat
*/
public class TicTacToe extends JFrame {

/*declare the components of the window*/
JPanel iconPanel;
JPanel tictactoeBoard;
JPanel emptyPanel;
JLabel chooseLabel;
JRadioButton xButton;
JRadioButton oButton;
ButtonGroup bg;
JButton resetButton;
JButton exitButton;
JButton undoButton;
JSplitPane rightPane;
JSplitPane pane;
MouseAdapterMod mam;


public static void main(String args[])
{
    new TicTacToe();
}

public TicTacToe() {

    iconPanel = new JPanel();
    tictactoeBoard = new JPanel();
    emptyPanel = new JPanel();
    chooseLabel = new JLabel("Choose your symbol :");
    xButton = new JRadioButton("X");
    oButton = new JRadioButton("O");
    bg = new ButtonGroup();
    bg.add(xButton);
    bg.add(oButton);

    /*add the label and the radio buttons too the empty panel*/
    emptyPanel.add(chooseLabel);
    emptyPanel.add(xButton);
    emptyPanel.add(oButton);
    emptyPanel.setLayout(new FlowLayout());
    /*add the exit,undo and reset buttons to the icon panel*/
    iconPanel.setLayout(new GridLayout(3, 1, 3, 3));
    resetButton = new JButton("Reset");
    exitButton = new JButton("Exit");
    undoButton = new JButton("Undo Move");
    iconPanel.add(resetButton);
    iconPanel.add(exitButton);
    iconPanel.add(undoButton);

    /*Set layout of the tictactoe board and add the game buttons to it */
    tictactoeBoard.setLayout(new GridLayout(3, 3));
    /* Mouse adapter object that listens to the buttons in the tic tac toe board */
    mam = new MouseAdapterMod(xButton);
    for (int i = 0; i < 9; i++) {
        JButton button = new JButton("");
        button.addMouseListener(mam);
        tictactoeBoard.add(button);     
    }
    /*add the icon panel and the empty panel to the right pane*/
    rightPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, iconPanel, emptyPanel);

    pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tictactoeBoard, rightPane);
    add(pane);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400, 400);
    //setMaximumSize(new Dimension(500, 500));
    setMinimumSize(new Dimension(700, 500));
    setLocationRelativeTo(null);
    pack();
    setTitle("Tic Tac Toe");
    setLocationRelativeTo(null);
    setVisible(true);
 }
}