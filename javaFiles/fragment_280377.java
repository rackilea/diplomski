import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Automato extends JFrame implements KeyListener {

    public static void main(String args[]) {
        new Automato();
    }

    JLabel lbNumero = new JLabel("0");
    private int i;


    Automato() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setTitle("Automato");
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        lbNumero.setFont(new Font("Arial", Font.PLAIN, 200));
        lbNumero.setForeground(Color.red);
        addKeyListener(this);
        add(lbNumero);
        setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int teclaPressionada = e.getKeyCode();

            if (teclaPressionada == KeyEvent.VK_NUMPAD1&& i<9) {
                i++;
                lbNumero.setText("" + i);
                System.out.println(i);
            }

        }


    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

}