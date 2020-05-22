public void mousePressed(MouseEvent e) {
    if (e.getClickCount() >= 2) {
        doubleClick = true;
         verticalBalls.add(new VerticalBall(e.getX(), e.getY(), canvasWidth, canvasHeight));
        System.out.println("double click");
    }
}