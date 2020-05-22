private Arc2D myArc = null;

public void paint(Graphics g)  {
    Graphics2D g2 = (Graphics2D) g;

    if (myArc != null) {
        g2.setPaint(Color.RED.darker().darker());
        // g2.fill(new Arc2D.Double(200, 100, 350, 350, 45, 90, Arc2D.PIE));
        g2.fill(myArc);
    }
}


@Override
public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    if (keyCode == KeyEvent.VK_UP) {
    System.out.println("Pressed Up Key");
    // g2.setPaint(Color.RED);
    // g2.fill(new Arc2D.Double(200, 100, 350, 350, 45, 90, Arc2D.PIE));

    // here change or create new Arc2D object and assign to myArc
    // perhaps changing the Y location of the arc
    myArc = // .... critical code here

    // then repaint
    repaint();
}