package main;
import java.awt.Graphics;

public class Ball{

private int x = 5;  
private int y = 30;  

// This method will help to animate the current object,
// The xPos and yPos will change, then frame will be repainted
public void setPos(int xPos, int yPos)
{
    x = xPos;
    y = yPos;
}

public void drawBall(Graphics g)
{
    g.setColor(Color.GREEN);
    g.fillOval(x, y, 30, 30);
}