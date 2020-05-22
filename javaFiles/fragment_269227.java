@Overrride // since you're overriding.
public void paint(Graphics g) {
    super.paint(g);

    if(shapetype != null) {
        shapetype.draw(g);
    }
}