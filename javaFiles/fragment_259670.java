// This is the x/y position of the top, at the top/left point,
    // I've placed it at the center of my screen, but you get the idea
    double x = (getWidth() - base.getWidth()) / 2d;
    double y = (getHeight() - base.getHeight()) / 2d;

    // Translate the location to the x/y, this makes the top/left 0x0...
    // much easier to deal with...
    AffineTransform at = AffineTransform.getTranslateInstance(x, y);
    g2d.setTransform(at);
    // Draw the base...
    g2d.drawImage(base, 0, 0, this);

    // Offset the turret, in my testing, this was 8x8 from the bases
    // top/left
    at.translate(8, 8);
    if (targetPoint != null) {
        // Calculate the delta between the mouse and the center point
        // of the turret, this is in screen coordinates and not
        // translated coordinates
        double deltaX = (x + 8) - targetPoint.x;
        double deltaY = (y + 8) - targetPoint.y;

        // Calculate the rotation required to point at the mouse
        // Had to apply an offset to allow for the default orientation
        // of the tank...
        double rotation = Math.atan2(deltaY, deltaX) + Math.toRadians(180d);
        // Rotate around the anchor point of the turret
        // Remember, we've translated so the top/left (0x0) is now the
        // turrets default position
        at.rotate(rotation, 4, 4);
    }
    // Transform the Graphics context
    g2d.setTransform(at);
    // Paint the turret
    g2d.drawImage(turret, 0, 0, this);
}
g2d.dispose();