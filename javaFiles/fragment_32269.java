Pixel rotated_pixel (double x, double y, Pixel rotation_center, Color color, double angle) {
    double x0 = rotation_center.x,
    y0 = rotation_center.y, // Oh god I hope I'm not also wrong about the field names now
    sinw = Math.sin(angle), cosw = Math.cos(angle),
    x_rot = x0 + (x-x0)*cosw - (y-y0)*sinw,
    y_rot = y0 + (y-y0)*cosw + (x-x0)*sinw;
    return new Pixel(x_rot, y_rot, color); // or smth
}