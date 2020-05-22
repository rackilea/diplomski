boolean zPressed = false;

public void keyPressed(KeyEvent ke) {
    if(ke.getKeyCode() == KeyEvent.VK_Z)
    {
        if (!zPressed) {
          channel.noteOn (((WhiteKey) WhiteKeys[0]).getNote (), 127);
          zPressed = true;
       }
    }
  }

public void keyReleased(KeyEvent ke) {
    if(ke.getKeyCode() == KeyEvent.VK_Z)
    {
      zPressed = false;
    }