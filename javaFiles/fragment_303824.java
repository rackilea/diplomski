int x = Integer.MIN_VALUE;
...
protected void paintComponent(Graphics g){
    super.paintComponent(g);
    if ( x == Integer.MIN_VALUE ){
        x = -g.getFontMetrics().stringWidth(text);
    }
    ...
}