public void paint(Graphics2D g) {
    if (coll){
        Random r = new Random();
        g.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
        coll = false;
    }
    g.fillOval(x, y, DIAMETER, DIAMETER);
}