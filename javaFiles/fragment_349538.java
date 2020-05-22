long mousePressed;
long mouseReleased;
long mousePressTime;

@Override
public void mousePressed(java.awt.event.MouseEvent e) {
    mousePressed = e.getWhen();
}

@Override
public void mouseReleased(java.awt.event.MouseEvent e) {
    mouseReleased = e.getWhen();

    mousePressTime = mouseReleased - mousePressed;

    System.out.println("PRESS TIME "+mousePressTime);
}