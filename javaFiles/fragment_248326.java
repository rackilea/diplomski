double dx = event.getX() - 150;
    double dy = event.getY() - 375;
    double len = Math.hypot(dx, dy);
    if (len > 75) {
      dx = dx*75/len;
      dy = dy*75/len;
    }
    _touchingPoint.x = (int)dx + 150;
    _touchingPoint.y = (int)dy + 375;