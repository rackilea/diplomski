public void paintComponent(Graphics f) {
    super.paintComponent(f);

    for (int i = 0; i < 10; i++ ){
        f.setColor(Color.RED);
        f.drawOval((int)(Math.random() * ((440 - 0) + 0) + 0), (int)(Math.random() * ((500 - 0) + 0) + 0), 50, 50);
    }
}