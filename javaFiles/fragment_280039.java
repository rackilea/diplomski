public boolean touchedPoint(int mNewX, int mNewY) {
        boolean touchedPoint = false;
        int height = 0;
        int width = 0;

        for (Point point : points) {
            height = monsterTypes[point.TYPE - 1].getHeight();
            width = monsterTypes[point.TYPE - 1].getWidth();

            if (point.x + width < mNewX || point.x > mNewX + width
                    || point.y + height < mNewY || point.y > mNewY + height) {
                touchedPoint = false;
                point.spotted = false;
            } else {
                touchedPoint = true;
                point.spotted = true;
                return touchedPoint;
            }
        }
        return touchedPoint;
    }