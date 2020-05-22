public ArrayList<Rect> getObjectBounds() {
        // You can also return just an array.. like Rect[] listToReturn etc
        ArrayList<Rect> listToReturn = new ArrayList(obstacles.size());
        for (Obstacle item : obstacles) {
            listToReturn.add(item.getObjectBounds);
        }
        return listToReturn;
    }