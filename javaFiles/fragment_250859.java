class GameTest extends JFrame implements ActionListener{

JPanel panel = new JPanel();
JButton[][] buttons = new JButton[4][4];
JButton button0 = new JButton("EMPTY");
int emptyIndex;
int sourceIndex;
int sourceRow;
int sourceCol;
int blankRow;
int blankCol;

public GameTest() {
    add(panel);
    setBackground(Color.RED);
    panel.setLayout(new GridLayout(4,4));
    int i = 1;
    for (int row = 0; row < buttons.length; row++) {
        for (int col = 0; col < buttons.length; col++ ) {
            if (row == 3 && col == 3) {
                buttons[row][col] = button0;
                panel.add(buttons[row][col]);
                buttons[row][col].setBackground(Color.WHITE);
                buttons[row][col].setName("button0");
            }
            else{
                buttons[row][col] = new JButton(i + "");
                panel.add(buttons[row][col]);
                buttons[row][col].addActionListener(this);
                buttons[row][col].setBackground(Color.RED);
                buttons[row][col].setName("button" + i);
                buttons[row][col].setFont(new Font("Arial", Font.PLAIN, 30));
                i++;
            }
        }
    }
    setCursor(new Cursor(Cursor.HAND_CURSOR));
    setResizable(false);
    setLocation(500,200);
    setSize(400,400);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
}

public boolean isSwappable(JButton button) {



    // för att hitta platsen på knappen man trycker och även den blanka platsen
    for (int row = 0; row < buttons.length; row++) {
        for (int col = 0; col < buttons.length; col++ ) {
            if (buttons[row][col] == button) {
                sourceRow = row;
                sourceCol = col;
            }
            else if (buttons[row][col] == button0) {
                blankRow = row;
                blankCol = col;
            }
        }
    }
    sourceIndex = (sourceRow * 4) + sourceCol;
    emptyIndex = (blankRow * 4) + blankCol;
    // om den är till höger
    if ( sourceCol != 3 && sourceRow == blankRow && buttons[sourceRow][sourceCol + 1] == button0) {
        return true;
    }
    // om den är till vänster
    else if (sourceCol != 0 && sourceRow == blankRow && buttons[blankRow][sourceCol - 1] == button0) {
        return true;
    }
    //om den är nedanför
    else if (sourceRow != 0 && sourceCol == blankCol && buttons[sourceRow - 1][sourceCol] == button0) {
        return true;
    }
    //om den är ovanför
    else if (sourceRow != 3 && sourceCol == blankCol && buttons[sourceRow + 1][sourceCol] == button0) {
        return true;
    }




    return false;
}

@Override
public void actionPerformed(ActionEvent e) {
    JButton source = (JButton)e.getSource();
    System.out.println(isSwappable(source));
    if (isSwappable(source)) {



        JButton tempButton = buttons[sourceRow][sourceCol];
        buttons[sourceRow][sourceCol] = buttons[blankRow][blankCol];
        buttons[blankRow][blankCol] = tempButton;

        if (emptyIndex < sourceIndex){
            panel.remove(button0);
            panel.remove(source);
            panel.add(source, emptyIndex);
            panel.add(button0, sourceIndex);
            revalidate();
            repaint();
        }
        else if (emptyIndex > sourceIndex){
            panel.remove(button0);
            panel.remove(source);
            panel.add(button0, sourceIndex);
            panel.add(source, emptyIndex);
            revalidate();
            repaint();
        }

    }
  }
}