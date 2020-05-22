private boolean insideButton(Rectangle buttonRect, Point mousePt) {
    if (buttonRect.contains(mousePt)) {
        int r = (int)buttonRect.getHeight()/2; // radius of either of the circles that make up the sides of the rectangle
        if(mousePt.x <= buttonRect.getWidth()/2) { // if it is on the left of the button
            Point center = new Point((int)buttonRect.getX()+r, (int)buttonRect.getY()+r); // the center of the circle on the left
            double lengthToPoint = Math.pow(Math.pow(mousePt.x-center.x, 2)+Math.pow(mousePt.y-center.y, 2), 1.0/2); // length from center to the point that the user clicked at
            if(lengthToPoint > r && mousePt.x < center.x) { // if it is to the left of the center and out of the circle
                return false;
            } else {
                return true;
            }
        } else { // if it is on the right, the rest of the code is just about the same as the left circle
            Point center = new Point((int)buttonRect.getWidth()-r, (int)buttonRect.getY()+r);
            double lengthToPoint = Math.pow(Math.pow(mousePt.x-center.x, 2)+Math.pow(mousePt.y-center.y, 2), 1.0/2);
            if(lengthToPoint > r && mousePt.x > center.x) {
                return false;
            } else {
                return true;
            }
        }
    } else {
        return false;
    }
}