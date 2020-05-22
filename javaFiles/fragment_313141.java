@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    int min = Integer.MAX_VALUE;
    int minIndex = -1;
    int max = -Integer.MAX_VALUE;
    int maxIndex = -1;

    for (i = 0; i < pointList.size() - 1; i++) {
        length = (int) Math.sqrt(Math.pow(pointList.get(i).x - pointList.get(i + 1).x, 2)
                + Math.pow(pointList.get(i).y - pointList.get(i + 1).y, 2));

        g.setColor(Color.cyan);
        g.drawString("" + length, (pointList.get(i).x + pointList.get(i + 1).x) / 2, (pointList.get(i).y + pointList.get(i + 1).y) / 2);

    }
    totalDistance += length;

    for (i = 0; i < pointList.size() - 1; i++) {

        Point from = pointList.get(i);
        Point to = pointList.get(i + 1);

        int distance = getDistance(from, to);
        if (distance == longest) {
            g.setColor(Color.WHITE);
        } else if (distance == shortest) {
            g.setColor(Color.GREEN);
        } else {
            g.setColor(Color.BLACK);
        }
        //...