static class MyPanel extends JPanel implements Scrollable
{
  MyPanel(LayoutManager layout)
  {
     super(layout);
  }

  public Dimension getPreferredScrollableViewportSize()
  {
     return getPreferredSize();
  }

  public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction)
  {
     return 0;
  }

  public boolean getScrollableTracksViewportHeight()
  {
     return false;
  }

  public boolean getScrollableTracksViewportWidth()
  {
     return true;
  }

  public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction)
  {
     return 0;
  }
}