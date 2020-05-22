@Override
public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.setColor(new Color(10, 50, 0));
    g.fillRect(0, 0, WIDTH, HEIGHT);

    g.setColor(Color.BLACK);
    for(int i = 0; i < WIDTH / 10; i++) {
        g.drawLine(i * 10, 0, i * 10, HEIGHT);
    }

    for(int i = 0; i < HEIGHT / 10; i++) {
        g.drawLine(0, i * 10, WIDTH, i * 10);
    }

    b.draw(g, x, y);
}