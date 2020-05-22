public static void fullscreenKey(KeyEvent e2, JFrame frame)
{
    int key = e2.getKeyCode();
    if(key == KeyEvent.VK_F1)
    {
        // This always executes if VK_F1 is pressed,
        // setting f1 to false
        fullscreen(false, frame);
        f1 = false;
    }
    if(key == KeyEvent.VK_F1 && !f1)
    {
        // f1 is now false, so this will execute too!
        fullscreen(true, frame);
        f1 = true;
    }
}