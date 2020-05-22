combo.addComponentListener( new ComponentAdapter()
{
  public void componentResized( ComponentEvent e )
  {
    Component component = (Component)e.getSource();
    System.out.println( "Resized: " + component.getSize() );
  }
});