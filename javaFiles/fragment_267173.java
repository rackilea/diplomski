textbo.addKeyListener(new KeyAdapter()
{
  public void keyPressed(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_ENTER)
    {
      System.out.println("ENTER key pressed");
    }
  }
});