@Override
    public synchronized void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            System.out.println("VK_SPACE");
        }
        if (e.getKeyCode() == KeyEvent.VK_C)
        {
            System.out.println("VK_C");
        }
    }