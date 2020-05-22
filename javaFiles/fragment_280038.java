public boolean onTouch(View view, MotionEvent event) {

        mNewX = (int) FloatMath.floor(event.getX());
        mNewY = (int) FloatMath.floor(event.getY());

        boolean touchedPoint = touchedPoint(mNewX, mNewY);

        switch (event.getAction()) {
        case MotionEvent.ACTION_MOVE:

            distanceMovedX.add(mNewX);
            distanceMovedY.add(mNewY);
            break;
        case MotionEvent.ACTION_UP:

            isMoveEvent = isMoveEvent();
            if (isMoveEvent) {
                for (Point point : points) {

                    if (point.spotted) {

                        // Your code
                    } 
                    i++;
                }
            } else {
                if (touchedPoint) {
                    for (Point point : points) { 
                        if (point.spotted) {

// Your code
                        }
                    }
                }
            }
            distanceMovedX.clear();
            distanceMovedY.clear();
            return true;
        }
        return true;
    }