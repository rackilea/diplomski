import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.applet.Applet;
import javax.swing.SwingUtilities;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Minesweeper extends Applet implements MouseListener{
// initializing all data types
JButton[] a; // The grid boxes
int counter = 1; // Obsolete
char[] letter; // Array of mine locations
int[] numbers; // Array of numbers; values and locations
boolean explode = false;
String name1;
String name2;
int mines;


public void init() {
    // The code below initializes and locates the grid
    a = new JButton[100];
    setLayout(new GridLayout(10, 10));
    // The code below fills the grid with buttons that can be clicked

    for (int counter = 0; counter < 100; counter++) {
        a[counter] = new JButton();
        a[counter].setText(" ");
        a[counter].setBackground(Color.white);
        a[counter].addMouseListener(this);
        add(a[counter]);
    }
            numbers = new int[100];
    letter = new char[100];
    for (counter = 0; counter < 10; counter++) {
        mines = (int) (Math.random() * 100); 
        if (letter[mines] == '*') {
            counter--;
        } else {
            letter[mines] = '*';
        }
    } 

    for (counter = 0; counter < 100; counter++) {
        numbers[counter] = 0;
    }

    for (int search = 0; search < 10; search++) {
        for (int searchb = 0; searchb < 10; searchb++) {
            if (letter[search * 10 + searchb] == '*') {
                if (search != 0) {
                    numbers[((search - 1) * 10) + searchb]++;
                }
                if (search != 9) {
                    numbers[((search + 1) * 10) + searchb]++;
                }
                if (searchb != 0) {
                    numbers[((search * 10) + searchb) - 1]++;
                }
                if (searchb != 9) {
                    numbers[((search * 10) + searchb) + 1]++;
                }
                if ((search != 0) && (searchb != 0)) {
                    numbers[(((search - 1) * 10) + searchb) - 1]++;
                }
                if ((search != 9) && (searchb != 9)) {
                    numbers[(((search + 1) * 10) + searchb) + 1]++;
                }
                if ((search != 0) && (searchb != 9)) {
                    numbers[(((search - 1) * 10) + searchb) + 1]++;
                }
                if ((search != 9) && (searchb != 0)) {
                    numbers[(((search + 1) * 10) + searchb) - 1]++;
                }

            }

        }

    }
    for (int counter = 0; counter < 100; counter++) {
        if(letter[counter]!= '*')
        letter[counter] = (char) ('0' + numbers[counter]);
    }
}


@Override
public void mouseClicked(MouseEvent e) {
    // TODO Auto-generated method stub

}


@Override
public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub

}


@Override
public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub

}


@Override
public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub

}


@Override
public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub

}

}