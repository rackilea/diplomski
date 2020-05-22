private class DotsListener implements MouseListener, MouseMotionListener {

    public void mouseClicked(MouseEvent event) {
        boolean spotSelected = false;

        int count = 0;
        while (count < pointList.size() && !spotSelected) {
            Point current = pointList.get(count).getPoint();

            if (getDistance(event.getPoint(), current) <= SIZE) {
                // --- Spot/circle selected or clicked on again
                pointList.get(count).addCount();
                spotSelected = false;
            }

            count++;
        }

        // --- Checks whether a new object needs to be created
        if (!spotSelected) {  // spotSelected == false
            pointList.add(new PointCount(event.getPoint()));

            if (pointList.size() > 1) {
                // Here, you now need to determine if the distance between the this and
                // the previous point is the shortest or longest
                longest = Math.max(longest, getDistance(pointList.get(pointList.size() - 1), pointList.get(pointList.size() - 2)));
                shortest = Math.min(shortest, getDistance(pointList.get(pointList.size() - 1), pointList.get(pointList.size() - 2)));
            }
        }

        repaint();
    }