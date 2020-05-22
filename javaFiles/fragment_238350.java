private void initBall(Graphics2D graphics2d) 
{      
    but_Escape.setPreferredSize(new Dimension(100, 30));

    Graphics2D g2 = graphics2d;
    g2.fillOval(SCREEN_WIDTH / 2, 0, BALL_WIDTH, BALL_HEIGHT);

    // The problem is here 
    add(but_Escape);
    revalidate();
}