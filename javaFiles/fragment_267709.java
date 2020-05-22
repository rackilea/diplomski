JComponent subComponent = new JButton("JButton");    
MouseAdapter redispatcher = new MouseAdapter()
{
  @Override
  public void mouseEntered(MouseEvent evt)
  {
    dispatchMouseEvent(evt);
  }      
  @Override
  public void mouseExited(MouseEvent evt)
  {
    dispatchMouseEvent(evt);
  }
  @Override
  public void mouseMoved(MouseEvent evt)
  {
    dispatchMouseEvent(evt);
  }
  @Override
  public void mousePressed(MouseEvent evt)
  {
    dispatchMouseEvent(evt);
  }
  private void dispatchMouseEvent(MouseEvent evt)
  {
    Container parent = evt.getComponent().getParent();
    parent.dispatchEvent(SwingUtilities.convertMouseEvent(evt.getComponent(), evt, parent));
  }            
};
subComponent.addMouseListener(redispatcher);
subComponent.addMouseMotionListener(redispatcher);