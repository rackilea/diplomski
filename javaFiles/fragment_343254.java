public void mouseDragged (MouseEvent e) 
{
    // Determine x-val and length
    int xPos = X;
    int xLen = Math.abs(X - e.getX());
    if (e.getX() < X) {
        xPos = e.getX();
    }

    // Determine y-val and length
    int yPos = Y;
    int yLen = Math.abs(Y - e.getY());
    if (e.getY() < Y) {
        yPos = e.getY();
    }

    // Set bounds on rectangle
    rect.setBounds(xPos, yPos, xLen, yLen);
}