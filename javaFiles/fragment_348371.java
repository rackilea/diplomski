@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.black);
    for(Line line : shapes){
        g.drawLine(line.getFirst().x, line.getFirst().y, line.getLast().x, line.getLast().y);
    }
}