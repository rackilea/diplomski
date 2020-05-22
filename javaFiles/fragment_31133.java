public void setMarkupBoxes(
    List<Quad> value
    )
  {
    PdfArray quadPointsObject = new PdfArray();
    double pageHeight = getPage().getBox().getHeight();
    Rectangle2D box = null;
    for(Quad markupBox : value)
    {
      /*
        NOTE: Despite the spec prescription, Point 3 and Point 4 MUST be inverted.
      */
      Point2D[] markupBoxPoints = markupBox.getPoints();
      quadPointsObject.add(PdfReal.get(markupBoxPoints[0].getX())); // x1.
      quadPointsObject.add(PdfReal.get(pageHeight - markupBoxPoints[0].getY())); // y1.
      quadPointsObject.add(PdfReal.get(markupBoxPoints[1].getX())); // x2.
      quadPointsObject.add(PdfReal.get(pageHeight - markupBoxPoints[1].getY())); // y2.
      quadPointsObject.add(PdfReal.get(markupBoxPoints[3].getX())); // x4.
      quadPointsObject.add(PdfReal.get(pageHeight - markupBoxPoints[3].getY())); // y4.
      quadPointsObject.add(PdfReal.get(markupBoxPoints[2].getX())); // x3.
      quadPointsObject.add(PdfReal.get(pageHeight - markupBoxPoints[2].getY())); // y3.
      if(box == null)
      {box = markupBox.getBounds2D();}
      else
      {box.add(markupBox.getBounds2D());}
    }
    getBaseDataObject().put(PdfName.QuadPoints, quadPointsObject);

    /*
      NOTE: Box width is expanded to make room for end decorations (e.g. rounded highlight caps).
    */
    double markupBoxMargin = getMarkupBoxMargin(box.getHeight());
    box.setRect(box.getX() - markupBoxMargin, box.getY(), box.getWidth() + markupBoxMargin * 2, box.getHeight());
    setBox(box);

    refreshAppearance();
  }

  private static double getMarkupBoxMargin(
    double boxHeight
    )
  {return boxHeight * .25;}