private class WrappedCategoryPlot extends CategoryPlot
{
  @Override
  protected AxisSpace calculateAxisSpace( Graphics2D g2, Rectangle2D plotArea )
  {
     return new AxisSpace();
  }
}