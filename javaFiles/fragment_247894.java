MouseListener ml = new MouseListener(){
    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {
        ((JMenu)e.getSource()).doClick();
    }
  };
  jMenuFile.addMouseListener(ml);
  jMenuHelp.addMouseListener(ml);