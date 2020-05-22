public class Circle {
    //...

    public void paint(Graphics2D g2d) {
        g2d.setColor(co);
        g2d.fillOval(x, y, r * 2, r * 2);
    }

    //...

    public void randomColor() {
        setCo(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255));
    }

    //...

}