for (int first = 0; first < ballList.size(); first++) {
    Ball firstBall = (Ball) ballList.get(first);
    for (int second = first + 1; second < ballList.size(); second++) {
        Ball secondBall = (Ball) ballList.get(second);

        double distanceBetweenCentres = Math.hypot(
            firstBall.getCenterX() - secondBall.getCenterX(), 
            firstBall.getCenterY() - secondBall.getCenterY());

        if (distanceBetweenCentres <= firstBall.getRadius() + secondBall.getRadius()) {
            System.out.println("Collision between ball " + first + " and ball " + second);
        }

    }
}