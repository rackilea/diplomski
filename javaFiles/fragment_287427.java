protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    for ( Pipe pipe : pipes ){
        pipe.drawPipe(g);
    }
}