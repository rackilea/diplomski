public void paintOffscreen(Graphics page)
{
    //Draws the background
    bg.draw(page);

    //Moving square
    num++;
    if (num > 1200)
        num = 0;
    page.setColor(Color.yellow);
    page.fillRect(num,100,100,100);

    //Draws the buildings
    bldg1.draw(page);
    bldg2.draw(page);
    bldg3.draw(page);
    bldg4.draw(page);
    bldg5.draw(page);

    //Mouse move square
    int s = 100;

    page.setColor(Color.yellow);
    page.fillRect(mX - s / 2, mY - s / 2, s, s);

    repaint();
}