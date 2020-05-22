public void paint(Graphics g) {
    super.paint(g);
    if(this.isOccupied()) {
        g.setColor(occupant.getColor());
        g.fillOval(30,30,50,50);
    }
}