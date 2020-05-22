private boolean determineCollision(OBB obb, Vector3f separatingAxis, double velocityMagnitude, float ra, float rb, float r) {
    //Find the time, from 0 (the beginning of the frame) to 1 (the end of the frame), that the obb's first intersected.

    //If r is negative, the first OBB is to the "right." Otherwise, it is to the "left."
    collisionRightSide.add(r < 0);
    boolean currColRightSide = collisionRightSide.get(collisionRightSide.size() - 1);

    double timeRange[] = new double[2]; //From 0 (beginning of frame) to 1 (end of frame)

    //Perform a regular static test if there is no movement for optimization's sake
    boolean noStaticOverlap = Math.abs(r) > (ra + rb);
    if(velocityMagnitude == 0) {
        timeRange[0] = 0; timeRange[1] = 1;
        axisTimes.add(timeRange);
        return !noStaticOverlap;
    }

    double spaceBetweenProjections = Math.abs(r) - Math.abs(ra) - Math.abs(rb);

    //Note that if velocity magnitude is negative, the first OBB is moving "right," and the other way for positive.
    if(currColRightSide) {
        if(velocityMagnitude < 0) {
            if(noStaticOverlap) {
//                  System.out.println("(Right side) OBBs are moving away");
                return false;
            } else {
                timeRange[0] = 0;
                timeRange[1] = Math.abs(spaceBetweenProjections / velocityMagnitude);
            }
        } else if(velocityMagnitude > 0) {
            if(noStaticOverlap) {
                timeRange[0] = Math.abs(spaceBetweenProjections / velocityMagnitude);;
                timeRange[1] = Math.abs((spaceBetweenProjections + 2 * rb) / velocityMagnitude);
            } else {
                timeRange[0] = 0;
                timeRange[1] = Math.abs((spaceBetweenProjections + 2 * rb) / velocityMagnitude);
            }
        }
    } else {
        if(velocityMagnitude > 0) {
            if(noStaticOverlap) {
//                  System.out.println("(Left side) OBBs are moving away");
                return false;
            } else {
                timeRange[0] = 0;
                timeRange[1] = Math.abs(spaceBetweenProjections / velocityMagnitude);
            }
        } else if(velocityMagnitude < 0) {
            if(noStaticOverlap) {
                timeRange[0] = Math.abs(spaceBetweenProjections / velocityMagnitude);
                timeRange[1] = Math.abs((spaceBetweenProjections + 2 * rb) / velocityMagnitude);
            } else {
                timeRange[0] = 0;
                timeRange[1] = Math.abs((spaceBetweenProjections + 2 * rb) / velocityMagnitude);
            }
        }
    }       

    //Clamp values
    if(timeRange[0] < 0) timeRange[0] = 0;
    if(timeRange[1] > 1) timeRange[1] = 1;

    //Switch so that the greater value comes last
    if(timeRange[0] > timeRange[1]) {
        double temp = timeRange[0];
        timeRange[0] = timeRange[1];
        timeRange[1] = temp;
    }

    if(timeRange[0] > 1 && timeRange[1] < 0) return false;

    axisTimes.add(timeRange);

    return true;
}