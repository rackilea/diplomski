public class Drawing extends JFrame implements KeyListener {

int num = 1;
Panel2 jPanel2 = new Panel2();
Panel3 jPanel3 = new Panel3();

public Drawing() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    addKeyListener(this);
    setSize(300, 300);
}

@Override
public void keyTyped(KeyEvent e) {
}

private void changePanel() {
    if (num == 1) {
        remove(jPanel3);
        add(jPanel2);
        jPanel2.repaint();
        pack();
    }
    if (num == 2) {
        remove(jPanel2);
        add(jPanel3);
        jPanel3.repaint();
        pack();
    }
}

@Override
public void keyPressed(KeyEvent e) {
}

@Override
public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == e.VK_UP) {
        num = 1;
    }
    if (e.getKeyCode() == e.VK_DOWN) {
        num = 2;
    }
    changePanel(); // do the actual swap of the panels
}

public static void main(String args[]) {
    new Drawing();
}
}

class Panel2 extends JPanel {

Panel2() {
    setPreferredSize(new Dimension(500, 500));
}

public void paint(Graphics g) {
    super.paint(g); //always call!
    g.drawString("BLAH", 20, 20);
    g.drawRect(200, 200, 200, 200);
}
}

class Panel3 extends JPanel {

Panel3() {
    setPreferredSize(new Dimension(500, 500));
}

public void paint(Graphics g) {
    super.paint(g); //always call!
    g.drawString("BURP", 20, 20);
    g.drawOval(200, 200, 200, 200);
}
}