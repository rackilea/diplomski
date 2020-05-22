Rectangle2D box = null;
double maxQuadHeight = 0;
for(Quad markupBox : value)
{
  double quadHeight = markupBox.getBounds2D().getHeight();
  if (quadHeight > maxQuadHeight)
    maxQuadHeight = quadHeight;
  ...
}
...
double markupBoxMargin = getMarkupBoxMargin(maxQuadHeight);
box.setRect(box.getX() - markupBoxMargin, box.getY(), box.getWidth() + markupBoxMargin * 2, box.getHeight());
setBox(box);