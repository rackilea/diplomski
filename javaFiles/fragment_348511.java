@Override
public Actor hit (float x, float y, boolean touchable) {
    Actor hit = super.hit(x, y, touchable); //is in rectangle

    if (hit != null){ //reject corners if necessary
        boolean keep = true;
        if (x < rad){
            if (y < rad) keep = inCircle(x, y, rad, rad, rad);
            else if (y > getHeight() - rad) keep = inCircle(x, y, rad, getHeight() - rad, rad);
        } else if (x > getWidth() - rad){
            if (y < rad) keep = inCircle(x, y, getWidth() - rad, rad, rad);
            else if (y > getHeight() - rad) keep = inCircle(x, y, getWidth() - rad, getHeight() - rad, rad);
        }
        if (!keep) hit = null;
    }
    return hit;
}

private boolean inCircle(float x, float y, float centerX, float centerY, float radius) {
    float dx = x - centerX;
    float dy = y - centerY;
    return dx * dx + dy * dy <= radius * radius;
}