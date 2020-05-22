import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

public class TicTacToe extends JFrame {

private static final String TITLE = "Tic Tac Toe";
private static final int width = 600;
private static final int height = 800;

private Container content;
private JButton exitbutton;
private JButton initbutton;
private JButton[] spaces = new JButton[9];
private CellButtonHandler[] cellHandler = new CellButtonHandler[9];
private InitButtonHandler inithandler;
private ExitButtonHandler exithandler;
private JLabel turn;
private URL base;
private Image o, x, blank;
private Font myfont = new Font("Times New Roman", Font.BOLD, 78);
private ImageIcon icon;
private ImageIcon iconx;
private ImageIcon icono;

private boolean gameover;
private boolean turnX;

public TicTacToe() {
    setTitle(TITLE);
    try {
        URL url = new URL("http://i.stack.imgur.com/F0JHK.png");
        icon = new ImageIcon(url);
        URL urlx = new URL("http://i.stack.imgur.com/T5uTa.png");
        iconx = new ImageIcon(urlx);
        URL urlo = new URL("http://i.stack.imgur.com/yoKxT.png");
        icono = new ImageIcon(urlo);
    } catch (Exception e) {
        e.printStackTrace();
    }
    setSize(width, height);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);

    content = getContentPane();
    content.setBackground(Color.black);

    content.setLayout(new GridLayout(4, 3));

    for (int i = 0; i < spaces.length; i++) {
        spaces[i] = new JButton();
        cellHandler[i] = new CellButtonHandler();
        spaces[i].addActionListener(cellHandler[i]);
    }

    exitbutton = new JButton("Exit");
    exithandler = new ExitButtonHandler();
    exitbutton.addActionListener(exithandler);
    initbutton = new JButton("Clear");
    inithandler = new InitButtonHandler();
    initbutton.addActionListener(inithandler);

    turn = new JLabel("X's turn", SwingConstants.CENTER);
    turn.setForeground(Color.white);

    for (int i = 0; i < spaces.length; i++) {
        spaces[i].setBackground(Color.white);
        content.add(spaces[i]);
    }

    content.add(initbutton);
    content.add(turn);
    content.add(exitbutton);

    init();
}

public void init() {
    turnX = true;
    gameover = false;
    spaces[0].setIcon(icon);
    spaces[1].setIcon(icon);
    spaces[2].setIcon(icon);
    spaces[3].setIcon(icon);
    spaces[4].setIcon(icon);
    spaces[5].setIcon(icon);
    spaces[6].setIcon(icon);
    spaces[7].setIcon(icon);
    spaces[8].setIcon(icon);

    turn.setText("X's turn");

    setVisible(true);

}

public static void main(String[] args) {
    TicTacToe game = new TicTacToe();
}

private class CellButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        if (gameover) {
            return;
        }

        JButton pressed = (JButton) (e.getSource());

        if (pressed.getIcon().equals(icono) || pressed.getIcon().equals(iconx)) {
            return;
        }

        if (turnX) {
            pressed.setIcon(iconx);
        } else {
            pressed.setIcon(icono);
        }

        if (checkwinnerO()) {
            gameover = true;
            turn.setText("O Wins!");
            }

        if(checkwinnerX()){
            gameover = true;
            turn.setText("X Wins!");
        }
    }
}

private class ExitButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}

private class InitButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        init();
    }
}

public boolean checkwinnerO() {
    if (spaces[0].getIcon().equals(icono)
            && spaces[1].getIcon().equals(icono) && spaces[2].getIcon().equals(icono)) {
        return true;
    } else if (spaces[3].getIcon().equals(icono)
            && spaces[4].getIcon().equals(icono) && spaces[5].getIcon().equals(icono)) {
        return true;
    } else if (spaces[6].getIcon().equals(icono)
            && spaces[7].getIcon().equals(icono) && spaces[8].getIcon().equals(icono)) {
        return true;
    } else if (spaces[0].getIcon().equals(icono)
            && spaces[3].getIcon().equals(icono) && spaces[6].getIcon().equals(icono)) {
        return true;
    } else if (spaces[1].getIcon().equals(icono)
            && spaces[4].getIcon().equals(icono) && spaces[7].getIcon().equals(icono)) {
        return true;
    } else if (spaces[2].getIcon().equals(icono)
            && spaces[5].getIcon().equals(icono) && spaces[8].getIcon().equals(icono)) {
        return true;
    } else if (spaces[0].getIcon().equals(icono)
            && spaces[4].getIcon().equals(icono) && spaces[8].getIcon().equals(icono)) {
        return true;
    } else if (spaces[2].getIcon().equals(icono)
            && spaces[4].getIcon().equals(icono) && spaces[6].getIcon().equals(icono)) {
        return true;
    } else

        return false;
}

public boolean checkwinnerX() {
    if (spaces[0].getIcon().equals(iconx)
            && spaces[1].getIcon().equals(iconx) && spaces[2].getIcon().equals(iconx)) {
        return true;
    } else if (spaces[3].getIcon().equals(iconx)
            && spaces[4].getIcon().equals(iconx) && spaces[5].getIcon().equals(iconx)) {
        return true;
    } else if (spaces[6].getIcon().equals(iconx)
            && spaces[7].getIcon().equals(iconx) && spaces[8].getIcon().equals(iconx)) {
        return true;
    } else if (spaces[0].getIcon().equals(iconx)
            && spaces[3].getIcon().equals(iconx) && spaces[6].getIcon().equals(iconx)) {
        return true;
    } else if (spaces[1].getIcon().equals(iconx)
            && spaces[4].getIcon().equals(iconx) && spaces[7].getIcon().equals(iconx)) {
        return true;
    } else if (spaces[2].getIcon().equals(iconx)
            && spaces[5].getIcon().equals(iconx) && spaces[8].getIcon().equals(iconx)) {
        return true;
    } else if (spaces[0].getIcon().equals(iconx)
            && spaces[4].getIcon().equals(iconx) && spaces[8].getIcon().equals(iconx)) {
        return true;
    } else if (spaces[2].getIcon().equals(iconx)
            && spaces[4].getIcon().equals(iconx) && spaces[6].getIcon().equals(iconx)) {
        return true;
    } else

        return false;
}
}