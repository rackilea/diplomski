Point upLeft = new Point(
    // x-coordinate
        (int) Math.round(midx + ((oldx-midx) * Math.cos(objectAngleRad))
                              - ((oldy-midy) * Math.sin(objectAngleRad))),
    // y-coordinate
        (int) Math.round(midy + ((oldx-midx) * Math.sin(objectAngleRad))
                              + ((oldy-midy) * Math.cos(objectAngleRad))));