Image ball = null;

private void init()
{
    ball = new ImageIcon(getClass().getClassLoader()
                                   .getResource("ball.png")).getImage();
}

@Override
public void paintComponent(Graphics g)
{
    g.drawImage(ball, 0, 0, 100, 100, null);
}