double DegreeToRadien = Math.toRadians(_degrees);

    int ObjectXCenter = (int) (_object_x + ((_itemAnimation.getWidth() / 2)) - _thrustAnimation.getWidth() / 2);
    int ObjectYCenter = (int) (_object_y + ((_itemAnimation.getHeight() / 2)) - _thrustAnimation.getHeight() / 2);

    int xOffset = -1 * (_itemAnimation.getWidth() / 2);

    _thurstPosition.set
    (
        (int)(((xOffset) * Math.cos(DegreeToRadien)) + ObjectXCenter), 
        (int)(((xOffset) * Math.sin(DegreeToRadien)) + ObjectYCenter)
    );