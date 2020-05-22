import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class Builder extends JFrame implements KeyListener {

public JLabel plaatje = new JLabel();
public static Builder instance;

public static Builder getInstance() {
    if (instance == null) {
        instance = new Builder();
    }
    return instance;
}

public Builder() {
    setSize(getMaximumSize());
    this.addKeyListener(this);
    setLayout(null);
    plaatje.setText("UP");

    add(plaatje);
    plaatje.setBounds(0, 0, 50, 50);

}

public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_UP) {
        Builder.getInstance().plaatje.setText("UP");
        Builder.getInstance().plaatje.setLocation(Builder.getInstance().plaatje.getX(), Builder.getInstance().plaatje.getY() - 5);
        Builder.getInstance().plaatje.repaint();
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        Builder.getInstance().plaatje.setText("DOWN");
        Builder.getInstance().plaatje.setLocation(Builder.getInstance().plaatje.getX(), Builder.getInstance().plaatje.getY() + 5);
        Builder.getInstance().plaatje.repaint();
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        Builder.getInstance().plaatje.setText("LEFT");
        Builder.getInstance().plaatje.setLocation(Builder.getInstance().plaatje.getX() - 5, Builder.getInstance().plaatje.getY());
        Builder.getInstance().plaatje.repaint();
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        Builder.getInstance().plaatje.setText("RIGHT");
        Builder.getInstance().plaatje.setLocation(Builder.getInstance().plaatje.getX() + 5, Builder.getInstance().plaatje.getY());
        Builder.getInstance().plaatje.repaint();
    }

}

@Override
public void keyReleased(KeyEvent e) {

}

@Override
public void keyTyped(KeyEvent e) {

}

public static void main(String[] args) {
    Builder.getInstance().setVisible(true);
}
}