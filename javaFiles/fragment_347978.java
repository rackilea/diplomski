import acm.graphics.GRect;

import acm.program.*;

public class Pyramid extends GraphicsProgram 
{

    public static final int BRICK_WIDTH = 30;

    public static final int BRICK_HEIGHT = 12;

    public static final int BRICK_IN_BASE = 14;

    public void run() 
    {
        setSize(800,400);
        int x = 100;
        int y = 380;
        for (int i = 0; i<14; i++)
        {
            GRect rec = new GRect (x, y,BRICK_WIDTH,BRICK_HEIGHT);
            x += BRICK_WIDTH;
            add(rec);
        }

    }

}