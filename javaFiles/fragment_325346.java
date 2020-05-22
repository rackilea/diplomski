public class Paddle extends JPanel {

Paddle(){

        this(0, 0, 20, 40);

}

Paddle(int x, int y, int width, int height){

        setBounds(x, y, width, height);

}

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.BLACK);
    // The graphics context has already been translated to x/y for use,
    // so we don't need to care about it
    g.fillRect(0, 0, getWidth(), getHeight());
}

public void moveDown(){

        setLocation(getX(), getY() + 3);

}

public void moveUp(){

        setLocation(getX(), getY() - 3);

}