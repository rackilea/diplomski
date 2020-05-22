// If line segments would overlap, this gets set to false.
  //
  boolean drawSegment = true;

  Line2D.Double segment = new Line2D.Double( sx, midy, tx, midy );

  // Associate the middle-y point with the bounds of the target object.
  // On subsequent draws of targets with a similar mid-y, make sure that
  // there are no overlapping lines.
  //
  if( midPointMap.put( midy, segment ) != null ) {
    // Check previous lines for overlap. Each previous line segment has
    // values in the form: (sx, mid-y)-(tx, mid-y), which map to
    // (getX1(), midy)-(getX2(), midy).
    //
    for( Line2D.Double psegment : midPointMap.getValues( midy ) ) {
      // If the lines have the same source point, and differ in their
      // target point, then they might overlap
      //
      if( sx == psegment.getX1() && tx != psegment.getX2() ) {
        double pdx = psegment.getX1() - psegment.getX2();
        double cdx = sx - tx;

        // At this juncture: the mid-y points are the same, the source
        // points of the previous segment and the current segment are the
        // same, and the target points of the segments differ.
        //
        // If both lines go in the same direction (relative to the same
        // source point), then they overlap. The difference of the tx
        // and X2 points is how much overlap exists.
        //
        // There are two actionable possibilities: (1) psegment is longer
        // than the current segment; or (2) psegment is shorter.
        //
        // If psegment is longer, then no segment must be drawn. If
        // psegment is shorter, the difference between psegment and the
        // current segment must be drawn.
        //
        if( tx < sx && psegment.getX2() < sx ) {
          // SEGMENT IS TO THE LEFT OF SOURCE
          //
          if( pdx > cdx ) {
            // If the previous segment is longer, then draw nothing.
            //
            drawSegment = false;
          }
          else {
            // If the previous segment is shorter, then draw the
            // difference. That is, change the source point for
            // this segment to the target point of the previous segment.
            //
            sx = psegment.getX2();
          }
        }
        else if( tx > sx && psegment.getX2() > sx ) {
          // SEGMENT IS TO THE RIGHT OF SOURCE
          //
          if( pdx < cdx ) {
            // If the previous segment is longer, then draw nothing.
            //
            drawSegment = false;
          }
          else {
            // If the previous segment is shorter, then draw the
            // difference. That is, change the source point for
            // this segment to the target point of the previous segment.
            //
            sx = psegment.getX2();
          }
        }
      }
    }
  }

  // Draw the line for the bus.
  //
  if( drawSegment ) {
    result.moveTo( sx, midy );
    result.lineTo( tx, midy );
  }