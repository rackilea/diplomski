public GUI() {
  // class attributes
  protected Component entered = null;
  protected Border    defaultB    = BorderFactory...;
  protected Border    highlighted = BorderFactory...;

  ....
  JPanel pDraw = new JPanel();
  ....
  for(Component component: pDraw.getComponents()){
     JLabel lbl = (JLabel)component;

     //add mouse listener to grid box which contained image
     if (lbl.getIcon() != null)
        lbl.addMouseListener(this);
  }

  public void mouseEntered(MouseEvent e) {
     if (!(e.getSource() instanceof Component)) return;
     exit();
     enter((Component)e.getSource());
  }

  public void mouseExited(MouseEvent e) {
     exit();
  }

  public void enter(Component c) {
     //change cursor appearance to HAND_CURSOR when the mouse pointed on images
     Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR); 
     setCursor(cursor);
     c.setBorder(highlighted);
     entered = c;
  }

  public void exit() {
     Cursor cursor = Cursor.getDefaultCursor();
     setCursor(cursor);
     if (entered != null) {
        entered.setBorder(defaultB);
        entered = null;
     }
  }