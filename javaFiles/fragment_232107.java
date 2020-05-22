public void keyPressed(KeyEvent arg0)
{
    boolean[] keys = new boolean[KeyEvent.KEY_TYPED];
    keys[arg0.getKeyCode()] = true;

    if(keys[KeyEvent.VK_UP])
    {
        user.y -= user.Speed;
    }
    else if(keys[KeyEvent.VK_DOWN])
    {
        user.y += user.Speed;
    }
    else if(keys[KeyEvent.VK_LEFT])
    {
        user.x -= user.Speed;
    }
    else if(keys[KeyEvent.VK_RIGHT])
    {
        user.x += user.Speed;

    }

    setFocusable(true);
    repaint();
}