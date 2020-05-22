class overlay extends JPanel {

private lineStore data;

public overlay(lineStore data) {
    this.data = data;
}

public void paintComponent(Graphics g) {        
    super.paintComponent(g);
    this.setBackground(Color.WHITE);
    g.setColor(Color.BLUE);
    for (int i = 0; i < data.length; i++) {
        g.drawLine(data[i].x1,data[i].y1,data[i].x2,data[i].y2);
    }
}