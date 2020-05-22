public boolean inBrickbase(arkBall ark) {
    if (visible) {
        for (int x = getX(); x <= getX() + getXWidth(); x++) //starts at upper left corner(x,y)
        {
            for (int y = getY(); y <= getY() + getYWidth(); y++) {
                if (distance(x, y, ark.getX(), ark.getY()) <= ark.getRadius()) //checks every point on the bumper
                {
                    visible = false;
                    return true;
                }
            }
        }
    }
    return false;
}