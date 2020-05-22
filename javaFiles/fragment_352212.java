public static void fullscreenKey(KeyEvent e2, JFrame frame)
{
    int key = e2.getKeyCode();
    if(key == KeyEvent.VK_F1)
    {
        fullscreen(!f1, frame);            
        f1 = !f1;
    }     
}