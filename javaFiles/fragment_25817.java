class MyLayout extends GridBagLayout
{
  private Component owner;

  public MyLayout(Component owner)
  {
    this.owner = owner;
  }

  @Override
  protected void adjustForGravity(GridBagConstraints constraints,
                                  Rectangle          rect)
  {
    // Adjust position and width of first (GREEN) label if necessary
    if ((rect.x > 0) && (rect.x <= 2))
    {
      rect.width += rect.x;
      rect.x = 0;
    }

    // Adjust width of last (RED) label if necessary
    int gap = owner.getWidth() - rect.x - rect.width;
    if ((gap > 0) && (gap <= 2))
      rect.width += gap;
  }

} // class MyLayout