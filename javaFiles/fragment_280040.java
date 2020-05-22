public boolean isMoveEvent() {
        boolean isMoveEvent = false;
        boolean isMoveEventX = false;
        boolean isMoveEventY = false;

        for (int i = 0; i <= (points.size() -1); i++) {
            Log.d("point", "for loop entered");

            if (!distanceMovedY.isEmpty()) {
                Log.d("point.x", "distanceMovedY is not empty");
                int dMY = distanceMovedY.get(distanceMovedY.size() - 1) - distanceMovedY.get(0);

                if ((dMY > 50 || dMY <= 0) && dMY != 0) {
                    Log.d("point.y", "is move event");
                    Log.d("point.y", "dMY: " + dMY);
                    isMoveEventY = true;
                } else {
                    Log.d("point.x", "is no move event");
                    Log.d("point.x", "dMY: " + dMY);
                    isMoveEvent = false;
                    return isMoveEvent;
                }
            }
            if (!distanceMovedX.isEmpty()) {
                Log.d("point.x", "distanceMovedX is not empty");
                int dMX = distanceMovedX.get(distanceMovedX.size() - 1) - distanceMovedX.get(0);

                if (dMX <= 50 && dMX >= -50 && dMX != 0) {
                    Log.d("point.x", "is move event");
                    Log.d("point.x", "dMX: " + dMX);
                    isMoveEventX = true;
                } else {
                    Log.d("point.x", "is no move event");
                    Log.d("point.x", "dMX: " + dMX);
                    isMoveEvent = false;
                    return isMoveEvent;
                }
            }
            if (isMoveEventX && isMoveEventY) {
                Log.d("point", "is move event");
                isMoveEvent = true;
                return isMoveEvent;
            }
        }
        Log.d("point", "is no move event");
        return isMoveEvent;
    }