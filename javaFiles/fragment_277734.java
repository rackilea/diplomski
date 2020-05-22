public class MyClass extends JPanel implements KeyListener
{
    // Add your intialization code here

    @Override
    public void keyTyped(KeyEvent e)
    {
        switch (evt.getKeyCode())
        {
            case KeyEvent.VK_DOWN:
                myY += 5;
                break;
            case KeyEvent.VK_UP:
                myY -= 5;
                break;
            case KeyEvent.VK_LEFT:
                myX -= 5;
                break;
            case KeyEvent.VK_RIGHT:
                myX += 5;
                break;
        }
    }
}