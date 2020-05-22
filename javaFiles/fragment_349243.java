boolean windowsPressed;

public void keyPressed(KeyEvent e) {
    if(event.getExtendedKeyCode() == VK.WINDOWS) windowsPressed = true;
}

public void keyReleased(KeyEvent event)
{
    switch(event.getExtendedKeyCode())
    {
        case KeyEvent.VK_UP:
            if(!windowsPressed) gameManager.up();
            break;
        case KeyEvent.VK_DOWN:
            gameManager.down();
            break;
        case KeyEvent.VK_RIGHT:
            gameManager.right();
            break;
        case KeyEvent.VK_LEFT:
            gameManager.left();
            break;
        case KeyEvent.VK_WINDOWS:
            windowsPressed = false;
            break;
    }
}