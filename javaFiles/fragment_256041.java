public Aim coordinateChange(double changeInX, double changeInY) {
    return new Aim(x + changeInX, y + changeInY);
}

public Aim scale(double scaleFactor) {
   return new Aim(x * scaleFactor, y * scaleFactor);
}