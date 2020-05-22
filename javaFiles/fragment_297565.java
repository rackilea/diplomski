protected void onDraw(Canvas c)
{
    c.drawColor(Color.CYAN);
    handelPlayer();
    p = new Rect(xp, y, xp + player.getWidth(), y + player.getHeight());;
    wayrect = new Rect(x, yg, 0, 0);   // These rectangles also has their right bottom corner at (0,0), which might cause problems
    wayrect2 = new Rect(x + width, yg, 0, 0);
    e = new Rect(xe, yg - 250, xe + enemy.getWidth(), yg - 250 + enemy.getHeight()) ;
    c.drawBitmap(enemy, e.left, e.top, null);
    c.drawBitmap(player, p.left, p.top, null);
}


public void handelPlayer()
{
    if (Rect.intersects(p, e)){ //collision
        speedrun = 0;
    }

    x -= speed*speedrun;
    xe -= speed*speedrun;
    if (x + width < 0)
        x = 0;
    if (xe < -100)
        xe = 920;
    if (MainActivity.touch == 1)
    {
        y -= 100;//jump
        MainActivity.touch = 0;
        i = 1;
    }
    if (y <= height - height / 5)
        y += 3 * i / 10; //gravity
    i++;


}